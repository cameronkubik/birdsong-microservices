package microservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

@RestController
public class AdminController {
    
    private ArrayList<Movie> allMovies = new ArrayList<Movie>();
    private ArrayList<Movie> upcomingMovies = new ArrayList<Movie>();
    private ArrayList<Movie> searchMovies = new ArrayList<Movie>();
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
    @Value("${db2.url}")
    String db2Url;
    @Value("${db2.user}")
    String db2User;
    @Value("${db2.password}")
    String db2Pass;
    //https://api.themoviedb.org/3/movie/upcoming?api_key=12ab19db903903ba44c5e6bf73694e3c&language=en-US&page=1&region=US
    //https://api.themoviedb.org/3/search/movie?api_key=<<api_key>>&language=en-US&query=<<search_query>>&page=1&include_adult=false&region=<<region>>
    
    @RequestMapping("/admin/load-upcoming")
    public ArrayList<Movie> loadUpcomingMovies() throws Exception {
        HttpURLConnection connection;
        JSONObject responseJson;
        ArrayList<JSONObject> movieJSONObjects = new ArrayList<JSONObject>();
        StringBuilder jsonStringBuilder = new StringBuilder();
        URL requestUrl = new URL(requestUrlBase + upcomingUrlExtension + "api_key=" + apiKey + "&language=" + language + "&page=" + page + "&region=" + region);
        BufferedReader reader;
        String inputStream;

        // call tmdb for upcoming
        try {
            // establish connection
            connection = (HttpURLConnection) requestUrl.openConnection();
            // set connection settings
            connection.setDoOutput(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            
            // Display status
            System.out.println("Reading from API connection...");
            // Get data from response
            reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            while ((inputStream = reader.readLine()) != null) {
                jsonStringBuilder.append(inputStream);
            }  
        } catch (Exception exception) {
            System.out.print(exception);
            jsonStringBuilder.append("");
        }
        
        responseJson = new JSONObject(jsonStringBuilder.toString());

        // loop through list
        JSONArray movieJSONArray = responseJson.getJSONArray("results");
        for(int i = 0; i < movieJSONArray.length(); i++) {
            JSONObject movieJSON = movieJSONArray.getJSONObject(i);
            movieJSONObjects.add(movieJSON);
        }
        Array movieList = movieJSONObjects.toArray();
        for (Object movieObject: movieList) {
            JSONObject movieJson = (JSONObject) movieObject;
            //extract values we need
            String title = (String) movieJson.get("title");
            int id = (int) movieJson.get("id");
            String posterImagePath = (String) movieJson.get("poster_path");
            String overview = (String) movieJson.get("overview");
            String releaseDate = (String) movieJson.get("release_date");
            String backdropImagePath = (String) movieJson.get("backdrop_path");
            // create movie obj    
            Movie movieToAdd = new Movie(title, id, posterImagePath, overview, releaseDate, backdropImagePath, -1);
            // add to upcomingMovies Array
            upcomingMovies.add(movieToAdd);
            allMovies.add(movieToAdd);
        }
        
        return upcomingMovies;
    }

    @RequestMapping("/admin/search-movie")
    public ArrayList<Movie> loadSearch(@RequestParam(value="searchQuery", defaultValue="e404") String query) throws Exception {
        searchMovies.clear();
        StringBuilder jsonStringBuilder = new StringBuilder();
        try {
            URL requestUrl = new URL(requestUrlBase + searchUrlExtension + "api_key=" + apiKey + "&language=" + language + "&query=" + query + "&page=" + page + "&region=" + region);
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

        JSONObject responseJson = new JSONObject(jsonStringBuilder.toString());
        JSONArray movieArray;

        //Append movieArray
        movieArray = (JSONArray) responseJson.get("results");

        for (Object movieObject: movieArray) {
            JSONObject movieJson = (JSONObject) movieObject;
            //extract values we need
            String title = (String) movieJson.get("title");
            int id = (int) movieJson.get("id");
            String posterImagePath = (String) movieJson.get("poster_path");
            String overview = (String) movieJson.get("overview");
            String releaseDate = (String) movieJson.get("release_date");
            String backdropImagePath = (String) movieJson.get("backdrop_path");
            // create movie obj    
            Movie movieToAdd = new Movie(title, id, posterImagePath, overview, releaseDate, backdropImagePath, -1);
            // add to upcomingMovies Array
            searchMovies.add(movieToAdd);
            allMovies.add(movieToAdd);
        }
        //Loop through movieArray, appending what we need to searchMovies
        return searchMovies;
    }

    @RequestMapping("/admin/save-movie")
    public boolean saveMovieAsNowShowing(@RequestParam(value="movieId", defaultValue="-1") String movieIDString) throws Exception {
        Movie saveMovie = null;
        String url = db2Url;
        String user = db2User;
        String password = db2Pass;
        Connection con;
        Statement stmt;
        ResultSet rs;

        // find movie in allMovies
        for (Movie movieObject: allMovies) {
            if (movieObject.getId() == Long.valueOf(movieIDString)) {
                saveMovie = movieObject;
            }
        }

        // get connection with DB2
        // Load the driver
        Class.forName("com.ibm.db2.jcc.DB2Driver");

        // Create the connection using the IBM Data Server Driver for JDBC and SQLJ
        con = DriverManager.getConnection (url, user, password); 
        // Commit changes manually
        con.setAutoCommit(false);
        // Create the Statement
        stmt = con.createStatement();
        // Execute a query and generate a ResultSet instance
        rs = stmt.executeQuery("SELECT *  FROM MOVIES");
        rs.moveToInsertRow();
        rs.updateInt("MOVIEID", saveMovie.getId());
        rs.updateString("TITLE", saveMovie.getTitle());
        rs.updateString("IMAGEURI", saveMovie.getPosterImagePath());
        rs.insertRow();
        rs.moveToCurrentRow();
        rs.close();
        stmt.close();
        con.commit();
        con.close();
        
        // create query strings
        // execute queries

        return true;
    }
}