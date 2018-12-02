package com.birdsong.application.controller;

import com.birdsong.application.service.*;

import java.util.ArrayList;

import com.birdsong.application.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeScreenController {

    @Autowired
    HomeScreenService service = new HomeScreenService();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadHomeScreen(ModelMap model) {
        // Gather data from controller service object
        WelcomeMessage welcomeMessage = service.getWelcomeMessage();
        String specialAnnouncements = service.getSpecialAnnouncements();
        ArrayList<Movie> movieList = service.getNowShowingMovies();

        model.put("welcomeMessage", welcomeMessage);
        model.put("specialAnnouncements", specialAnnouncements);
        model.put("movieList", movieList);

        return "homeScreen";
    }
}