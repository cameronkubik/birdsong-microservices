package microservice;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonGetter;

public class HomeScreenContent {

    ArrayList<Movie> nowShowingMovies = new ArrayList<Movie>();
    String welcomeMessageText;
    String specialEventText;
    
    public HomeScreenContent() {
        
    }



    // @JsonGetter("title")
    // public String getTitle() {
    //     return title;
    // }
    
}