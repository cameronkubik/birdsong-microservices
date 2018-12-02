package com.birdsong.application.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import com.birdsong.application.model.*;
import com.birdsong.application.service.Db2Manager;

// Service for Model
@Service
public class HomeScreenService {

    private Db2Manager dbManager = new Db2Manager();

    static {
        // Collect db info here
        System.out.print("Home Screen initialized!");
    }

    public String getHelloWorld() {
        return "Hello World!";
    }

    public ArrayList<Movie> getNowShowingMovies() {
        ArrayList<Movie> nowShowingMovies = new ArrayList<Movie>();
        // call Db manager
        return nowShowingMovies;
    }
}