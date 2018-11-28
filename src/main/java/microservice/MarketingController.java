package microservice;

import java.util.ArrayList;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@RestController
public class MarketingController {

    private ArrayList<Movie> upcomingMovies = new ArrayList();
    private ArrayList<Movie> searchMovies = new ArrayList();
    private String requestUrlBase = "https://api.themoviedb.org/3";
    private String upcomingUrlExtension = "/movie/upcoming?";
    private String searchUrlExtension = "/search/movie?";
    
    @Value("${tmdb.apikey}")
    String apiKey;
    @Value("${tmdb.language}")
    String language;
    @Value("${tmdb.page}")
    String page;
    @Value("${tmdb.region}")
    String region;
    //https://api.themoviedb.org/3/movie/upcoming?api_key=12ab19db903903ba44c5e6bf73694e3c&language=en-US&page=1&region=US
    //https://api.themoviedb.org/3/search/movie?api_key=<<api_key>>&language=en-US&query=<<search_query>>&page=1&include_adult=false&region=<<region>>
    
    @RequestMapping("/marketing/load-upcoming")
    public ArrayList<Movie> loadUpcomingMovies() throws Exception {
        StringBuilder jsonStringBuilder = new StringBuilder();
        // call tmdb for upcoming
        try {
            URL requestUrl = new URL(requestUrlBase + upcomingUrlExtension + "api_key=" + apiKey + "&language=" + language + "&page=" + page + "&region=" + region);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setDoOutput(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = reader.readLine()) != null) {
                jsonStringBuilder.append(output);
            }  
        } catch (Exception exception) {
            System.out.print(exception);
        }
        JSONParser parser = new JSONParser();
        JSONObject responseJson = (JSONObject) parser.parse(jsonStringBuilder.toString());

        // loop through list
        int i = 0;
        JSONArray movieArray;
        movieArray = (JSONArray) responseJson.get("results");
        //extract values we need
        i++;
        // create upcomingMovie
        // add to upcomingMovies Array

        return upcomingMovies;
    }

    @RequestMapping("/marketing/search-movie")
    public ArrayList<Movie> loadSearch(@RequestParam(value="searchQuery", defaultValue="e404") String query) throws Exception {
        StringBuilder jsonStringBuilder = new StringBuilder();
        try {
            URL requestUrl = new URL(requestUrlBase + upcomingUrlExtension + "api_key=" + apiKey + "&language=" + language + "&query=" + query + "&page=" + page + "&region=" + region);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setDoOutput(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = reader.readLine()) != null) {
                jsonStringBuilder.append(output);
            }

        } catch (Exception exception) {
            System.out.print(exception);
        }

        //Create parser and parse response JSON
        JSONParser parser = new JSONParser();
        JSONObject responseJson = (JSONObject) parser.parse(jsonStringBuilder.toString());
        JSONArray movieArray;

        //Append movieArray
        movieArray = (JSONArray) responseJson.get("results");

        //Loop through movieArray, appending what we need to searchMovies
        return searchMovies;
    }
}