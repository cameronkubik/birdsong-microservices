package com.birdsong.application.model;


import com.fasterxml.jackson.annotation.JsonGetter;

public class Movie {
    
    private String title;
    private int id;
    private String posterImagePath;
    private String overview;
    private String releaseDate;
    private String backdropImagePath;
    private int duration;
    private int isCurrentShowing;
    private int isUpcomingShowing;

    public Movie(String _title, int _id, String _posterImagePath, String _overview, String _releaseDate, String _backdropImagePath) {
        title = _title;
        id = _id;
        posterImagePath = _posterImagePath;
        overview = _overview;
        releaseDate = _releaseDate;
        backdropImagePath = _backdropImagePath;
    }

    public Movie(String _title, int _id, String _posterImagePath, String _overview, String _releaseDate, String _backdropImagePath, int _duration, int _isCurrentShowing, int _isUpcomingShowing) {
        title = _title;
        id = _id;
        posterImagePath = _posterImagePath;
        overview = _overview;
        releaseDate = _releaseDate;
        backdropImagePath = _backdropImagePath;
        duration = _duration;
        isCurrentShowing = _isCurrentShowing;
        isUpcomingShowing = _isUpcomingShowing;
    }

    @JsonGetter("title")
    public String getTitle() {
        return title;
    }
    @JsonGetter("id")
    public int getId() {
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
    @JsonGetter("isCurrentShowing")
    public int getIsCurrentShowing() {
        return isCurrentShowing;
    }
    @JsonGetter("isUpcomingShowing") 
    public int getIsUpcomingShowing() {
        return isUpcomingShowing;
    }
    @JsonGetter("duration") 
    public int getDuration() {
        return duration;
    }
}