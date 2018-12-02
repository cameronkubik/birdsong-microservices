package com.birdsong.application.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;

import com.birdsong.application.model.*;
import com.birdsong.application.service.Db2Manager;

// Service for Model
@Service
public class HomeScreenService {

    private Db2Manager dbManager = new Db2Manager();

    public ArrayList<Movie> getNowShowingMovies() {
        ArrayList<Movie> nowShowingMovies = dbManager.getNowShowingMovies();
        return nowShowingMovies;
    }

    public WelcomeMessage getWelcomeMessage() {
        WelcomeMessage welcomeMessage = dbManager.getWelcomeMessage();
        return welcomeMessage;
    }

    public String getSpecialAnnouncements() {
        String specialAnnouncements = dbManager.getSpecialAnnouncements();
        return specialAnnouncements;
    }
}