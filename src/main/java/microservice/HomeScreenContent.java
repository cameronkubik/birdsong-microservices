package microservice;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonGetter;

public class HomeScreenContent {

    ArrayList<Movie> nowShowingMovies = new ArrayList<Movie>();
    String welcomeMessageText;
    String specialEventText;
    ArrayList<Movie> movieShowingsList;
    
    public HomeScreenContent() {
        movieShowingsList = getMovieShowingList();
    }

    private ArrayList<Movie> getMovieShowingList() {
        movieShowingsList = new ArrayList<Movie>(4);
        
    }

    // @JsonGetter("title")
    // public String getTitle() {
    //     return title;
    // }
    
}