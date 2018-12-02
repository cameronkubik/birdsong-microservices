package com.birdsong.application.controller;

import com.birdsong.application.service.*;
//import com.birdsong.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HomeScreenController {

    @Autowired
    HomeScreenService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadHomeScreen(ModelMap model) {
        model.put("name", "TEST");
        return "homeScreen";
    }
}