package microservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

@RestController
public class AdminController {

    @Autowired
    private Db2Manager dbManager = new Db2Manager();

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
    // @Value("${db2.url}")
    // String db2Url;
    // @Value("${db2.user}")
    // String db2User;
    // @Value("${db2.password}")
    // String db2Pass;
    //https://api.themoviedb.org/3/movie/upcoming?api_key=12ab19db903903ba44c5e6bf73694e3c&language=en-US&page=1&region=US
    //https://api.themoviedb.org/3/search/movie?api_key=<<api_key>>&language=en-US&query=<<search_query>>&page=1&include_adult=false&region=<<region>>
    
    @RequestMapping("/admin/load-upcoming")
    public ArrayList<Movie> loadUpcomingMovies() throws Exception {
        URL requestUrl = new URL(requestUrlBase + upcomingUrlExtension + "api_key=" + apiKey + "&language=" + language + "&page=" + page + "&region=" + region);
        String jsonString = queryTmdbApiForJsonString(requestUrl);
        JSONObject responseJson = new JSONObject(jsonString);
        
        return getMovieListFromResponseJson(responseJson);
    }

    @RequestMapping("/admin/search-movie")
    public ArrayList<Movie> loadSearch(@RequestParam(value="searchQuery", defaultValue="e404") String query) throws Exception {
        URL requestUrl = new URL(requestUrlBase + searchUrlExtension + "api_key=" + apiKey + "&language=" + language + "&query=" + URLEncoder.encode(query, "UTF-8") + "&page=" + page + "&region=" + region);
        String jsonString = queryTmdbApiForJsonString(requestUrl);
        JSONObject responseJson = new JSONObject(jsonString);
        
        return getMovieListFromResponseJson(responseJson);
    }

    @RequestMapping("/admin/save-movie")
    public boolean saveMovieAsNowShowing(@RequestParam(value="movieId", defaultValue="-1") String movieIDString, @RequestParam(value="isUpcoming", defaultValue="false") String isUpcoming) throws Exception {
        Movie saveMovie = null;
        boolean upcoming = Boolean.parseBoolean(isUpcoming);

        // Search movie on TMDB
        URL requestURL = new URL(requestUrlBase + "/movie/" + movieIDString + "?" + "api_key=" + apiKey + "&language=" + language);
        String jsonString = queryTmdbApiForJsonString(requestURL);

        //Create JSON object from response, create movie object from JSON
        JSONObject responseJson = new JSONObject(jsonString);
        saveMovie = getMovieFromExtendedJSON(responseJson, upcoming);

        if (saveMovie == null) {
            return false;
        }
        
        boolean connectionStatus = dbManager.initializeConnection();
        boolean saveStatus;

        if (!connectionStatus) {
            return false;
        }

        saveStatus = dbManager.saveMovie(saveMovie);

        return saveStatus;
    }

    private Movie getMovieFromJSON(JSONObject movieJson) throws Exception {
        //extract values we need
        String title = movieJson.getString("title");
        int id = movieJson.getInt("id");
        String posterImagePath = movieJson.getString("poster_path");
        String overview = movieJson.getString("overview");
        String releaseDate = movieJson.getString("release_date");
        String backdropImagePath = movieJson.getString("backdrop_path");
        // create movie obj    
        return new Movie(title, id, posterImagePath, overview, releaseDate, backdropImagePath);
    }

    private Movie getMovieFromExtendedJSON(JSONObject movieJson, boolean isUpcoming) throws Exception {
        //extract values we need
        String title = movieJson.getString("title");
        int id = movieJson.getInt("id");
        String posterImagePath = movieJson.getString("poster_path");
        String overview = movieJson.getString("overview");
        String releaseDate = movieJson.getString("release_date");
        String backdropImagePath = movieJson.getString("backdrop_path");
        int duration = movieJson.getInt("runtime");
        int upcoming;
        int current;

        if (isUpcoming == true) {
            upcoming = 1;
            current = 0;
        } else {
            upcoming = 0;
            current = 1;
        }

        // create movie obj    
        return new Movie(title, id, posterImagePath, overview, releaseDate, backdropImagePath, duration, current, upcoming);
    }

    private ArrayList<Movie> getMovieListFromResponseJson(JSONObject responseJson) throws Exception {
        JSONArray movieListJson = responseJson.getJSONArray("results");
        ArrayList<Movie> movieList = new ArrayList<Movie>();

        for (int i = 0; i < movieListJson.length(); i++) {
            JSONObject movieJSON = movieListJson.getJSONObject(i);
            Movie movie = getMovieFromJSON(movieJSON);
            movieList.add(movie);
            allMovies.add(movie);
        }

        return movieList;
    }

    private String queryTmdbApiForJsonString(URL requestUrl) throws Exception {
        StringBuilder jsonStringBuilder = new StringBuilder();

        try {
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setDoOutput(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String inputString;
            while ((inputString = reader.readLine()) != null) {
                jsonStringBuilder.append(inputString);
            }
        } catch (Exception exception) {
            System.out.print(exception);
            jsonStringBuilder.append("");
        }

        return jsonStringBuilder.toString();
    }
}