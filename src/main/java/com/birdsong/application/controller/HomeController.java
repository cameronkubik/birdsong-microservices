package com.birdsong.application.controller;

import com.birdsong.application.service.HomeService;
import com.birdsong.application.model.HomeContent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    HomeService service = new HomeService();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadHomeContent(ModelMap model) {
        HomeContent latestContent = service.getHomeContent();
        model.put("content", latestContent);
        return "home";
    }

}