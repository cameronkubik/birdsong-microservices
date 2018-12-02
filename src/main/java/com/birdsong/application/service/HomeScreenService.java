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

    public List<Movie> retrieveNowShowingMovies(boolean withUpcoming) {
        List<Movie> nowShowingMovies = new ArrayList<Movie>();
        return nowShowingMovies;
    }
}