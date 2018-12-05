package com.birdsong.application.service;

import org.springframework.stereotype.Service;

import com.birdsong.application.model.HomeContent;
import com.birdsong.application.model.Movie;

import java.util.ArrayList;

@Service
public class HomeService {

    private Db2Manager dbManager = Db2Manager.getInstance();
    

    public HomeContent getHomeContent() {
        HomeContent latestContent = dbManager.getHomeContent();
        return latestContent;
    }

    public String getWelcomeMessage() {
        return dbManager.getHomeContent().getWelcomeMessage();
    }

    public String getSpecialsMessage() {
        return dbManager.getHomeContent().getSpecialsMessage();
    }

    public ArrayList<Movie> getNowShowingMovies() {
        return dbManager.getHomeContent().getNowShowingMovies();
    }

    public void post(HomeContent content) {
        dbManager.postHomeContent(content);
    }
}