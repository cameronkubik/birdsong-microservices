package com.birdsong.application.controller;

import java.util.ArrayList;

import com.birdsong.application.service.*;
//import com.birdsong.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConcessionScreenController {

    @Autowired
    ConcessionScreenService service = new ConcessionScreenService();

    @RequestMapping(value = "/concession", method = RequestMethod.GET)
    public String loadConcessionItems(ModelMap model) {
        String testData = service.getSaleItemsList().toString();
        model.put("testData", testData);
        return "concessionScreen";
    }
}