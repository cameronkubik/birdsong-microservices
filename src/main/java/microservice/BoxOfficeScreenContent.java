package microservice;

import com.fasterxml.jackson.annotation.JsonGetter;

public class BoxOfficeScreenContent {
    
    Db2Manager dbManager;

    int adultTicketPrice;
    int childTicketPrice;
    
    int boxOfficeOpenTime;
    int firstMovieStartTime; 

    String announcementsText;

    public BoxOfficeScreenContent(Db2Manager _dbManager) {
        dbManager = _dbManager;

        adultTicketPrice = dbManager.getAdultTicketPrice();
        childTicketPrice = dbManager.getChildTicketPrice();

        boxOfficeOpenTime = dbManager.getBoxOfficeOpenTime();
        firstMovieStartTime = dbManager.getFirstMovieStartTime();

        announcementsText = dbManager.getAnnouncementsText();
    }

    @JsonGetter("adultTicketPrice")
    public int getAdultPriceGetter() {
        return adultTicketPrice;
    }

    @JsonGetter("childTicketPrice")
    public int getChildPriceGetter() {
        return childTicketPrice;
    }

    @JsonGetter("boxOfficeOpenTime")
    public int getBoxOfficeTimeGetter() {
        return boxOfficeOpenTime;
    }

    @JsonGetter("firstMovieStartTime")
    public int getMovieStartTimeGetter() {
        return firstMovieStartTime;
    }

    @JsonGetter("announcementsText")
    public String getAnnouncementsTextGetter() {
        return announcementsText;
    }
    
}