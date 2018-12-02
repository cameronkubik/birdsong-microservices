package com.birdsong.application.controller;

import com.birdsong.application.service.AboutUsScreenService;
//import com.birdsong.model.*;
import com.birdsong.application.service.BoxOfficeScreenService;//import com.birdsong.model.*;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutUsScreenController {

    @Autowired
    AboutUsScreenService service = new AboutUsScreenService();

    @RequestMapping(value = "/about-us", method = RequestMethod.GET)
    public String loadAboutUs(ModelMap model) {
        String testData = service.getAboutUs();
        model.put("testData", testData);
        return "aboutUsScreen";
    }
}