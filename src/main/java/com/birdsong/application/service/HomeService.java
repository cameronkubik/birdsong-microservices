package com.birdsong.application.service;

import org.springframework.stereotype.Service;

import com.birdsong.application.model.HomeContent;
import com.birdsong.application.model.Movie;

import java.sql.ResultSet;
// import com.ibm.db2.jcc.am.ResultSet;
import java.util.ArrayList;

@Service
public class HomeService {

    private Db2Manager dbManager = Db2Manager.getInstance();

    public String getWelcome() {
        return "Welcome human";
    }

    public String getSpecial() {
        return "Special human";
    }

    public HomeContent getHomeContent() {
        HomeContent loadedContent = dbManager.getHomeContentNEW();
        
        return loadedContent;
    }

    // public boolean postHomeContent(HomeContent newContent) {

    // }
    
}