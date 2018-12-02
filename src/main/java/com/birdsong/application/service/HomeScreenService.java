package com.birdsong.application.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import com.birdsong.application.model.*;

// Service for Model
@Service
public class HomeScreenService {

    static {
        // Collect db info here
        System.out.print("Home Screen initialized!");
    }

    public String getHelloWorld() {
        return "Hello World!";
    }

    public List<Movie> getNowShowingMovies() {
        List<Movie> nowShowingMovies = new ArrayList<Movie>();
        // call Db manager
        return nowShowingMovies;
    }
}