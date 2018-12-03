package com.birdsong.application.controller;

import java.util.ArrayList;

import com.birdsong.application.service.*;
import com.birdsong.application.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminConcessionController {

    @Autowired
    ConcessionScreenService service = new ConcessionScreenService();

    @RequestMapping(value = "/adminConcession", method = RequestMethod.GET)
    public String loadConcessionItems(ModelMap model) {
        //ArrayList<SaleItem> testData = service.getSaleItemsList();
        model.addAttribute("testData", service.getSaleItemsList());
        return "adminConcession";
    }
}