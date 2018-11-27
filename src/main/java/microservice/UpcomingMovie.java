package microservice;

public class UpcomingMovie {

    private final String parentTheaterID;
    private final String limit;
    private final String title;
    private final String rating;

    public UpcomingMovie(String theaterID, String limit) {
        this.parentTheaterID = theaterID;
        this.limit = limit;
        this.title = "";
        this.rating = "";
    }

    public String getId() {
        return parentTheaterID;
    } 
}