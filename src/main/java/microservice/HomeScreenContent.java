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
        welcomeMessageText = dbManager.getWelcomeMesssageText();
        specialEventText = dbManager.getSpecialEventText();
    }

    @JsonGetter("movieShowingsList")
    public ArrayList<Movie> getMovieShowingsListGetter() {
        return movieShowingsList;
    }
    @JsonGetter("welcomeMessageText")
    public String getWelcomeMessageTextGetter() {
        return welcomeMessageText;
    }
    @JsonGetter("specialEventText")
    public String getSpecialEventTextGetter() {
        return specialEventText;
    }
    
}