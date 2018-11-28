package microservice;

public class Movie {
    
    private final String title;
    private final long id;
    private final String posterImagePath;
    private final String overview;
    private final String releaseDate;
    private final String backdropImagePath;


    public Movie(String _title, long _id, String _posterImagePath, String _overview, String _releaseDate, String _backdropImagePath) {
        title = _title;
        id = _id;
        posterImagePath = _posterImagePath;
        overview = _overview;
        releaseDate = _releaseDate;
        backdropImagePath = _backdropImagePath;     
    }
}