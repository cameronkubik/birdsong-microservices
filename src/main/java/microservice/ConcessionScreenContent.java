package microservice;

import com.fasterxml.jackson.annotation.JsonGetter;

public class ConcessionScreenContent {
    
    private final String title;
    private final long id;
    private final String posterImagePath;
    private final String overview;
    private final String releaseDate;
    private final String backdropImagePath;
    private final int screenShowingOn;


    public ConcessionScreenContent(String _title, long _id, String _posterImagePath, String _overview, String _releaseDate, String _backdropImagePath, int _screenShowingOn) {
        title = _title;
        id = _id;
        posterImagePath = _posterImagePath;
        overview = _overview;
        releaseDate = _releaseDate;
        backdropImagePath = _backdropImagePath;
        screenShowingOn = _screenShowingOn;
    }

    @JsonGetter("title")
    public String getTitle() {
        return title;
    }
    @JsonGetter("id")
    public long getId() {
        return id;
    }
    @JsonGetter("posterImagePath")
    public String getPosterImagePath() {
        return posterImagePath;
    }
    @JsonGetter("overview")
    public String getOverview() {
        return overview;
    }
    @JsonGetter("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }
    @JsonGetter("backdropImagePath")
    public String getBackdropImagePath() {
        return backdropImagePath;
    }
    @JsonGetter("screenShowingOn")
    public int getScreenShowingOn() {
        return screenShowingOn;
    }
}