package microservice;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonGetter;

public class HomeScreenContent {

    Db2Manager dbManager;
    ArrayList<Movie> movieShowingsList;
    String welcomeMessageText;
    String specialEventText;
    
    public HomeScreenContent(Db2Manager _dbManager) {
        dbManager = _dbManager;
        movieShowingsList = dbManager.getNowShowingMovies();
    }

    // @JsonGetter("title")
    // public String getTitle() {
    //     return title;
    // }
    
}