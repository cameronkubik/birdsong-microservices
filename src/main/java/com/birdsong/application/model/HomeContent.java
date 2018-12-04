package com.birdsong.application.model;

import java.util.ArrayList;

import com.birdsong.application.service.HomeService;
import com.birdsong.application.model.Movie;

public class HomeContent {

    // Service to interact with Database
    private HomeService service = new HomeService();

    // private members that reflect dynamic components of the UI screens
    private ArrayList<Movie> nowShowingMovies;
    private String welcomeMessage;
    private String specialsMessage;

    /*
     * The constructor used for loading content to the website This will be called
     * for every request to the public home page
     */
    public HomeContent() {
        this.nowShowingMovies = new ArrayList<Movie>();
        this.welcomeMessage = service.getWelcome();
        this.specialsMessage = service.getSpecial();
    }

    /*
     * The constructor used by {HomeService service} to wrap content coming from the
     * database
     */
    public HomeContent(ArrayList<Movie> _nowShowingMovies, String _welcome, String _special) {
        this.nowShowingMovies = _nowShowingMovies;
        this.welcomeMessage = _welcome;
        this.specialsMessage = _special;
    }

    /*
     * GETTERS and SETTERS for Spring framework and UI content loading
     */
    
    public ArrayList<Movie> getNowShowingMovies() {
        return this.nowShowingMovies;
    }

    public void setNowShowingMovies(ArrayList<Movie> _nowShowingMovies) {
        this.nowShowingMovies = _nowShowingMovies;
    }

    public String getWelcomeMessage() {
        return this.welcomeMessage;
    }

    public void setWelcomeMessage(String _welcomeMessage) {
        this.welcomeMessage = _welcomeMessage;
    }

    public String getSpecialsMessage() {
        return this.specialsMessage;
    }

    public void setSpecialsMessage(String _specialsMessage) {
        this.specialsMessage = _specialsMessage;
    }

}