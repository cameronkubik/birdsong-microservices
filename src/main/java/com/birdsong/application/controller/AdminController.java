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
public class AdminController {

    private Db2Manager dbManager = Db2Manager.getInstance();

    // Pre load Classes for spring boot
    @Autowired
    ConcessionScreenService concessionService = new ConcessionScreenService();
    AboutUsScreenService aboutUsService = new AboutUsScreenService();
    FooterService footerService = new FooterService();

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String loadAdminHome(ModelMap model) {
        HomeScreenService homeService = new HomeScreenService();
        // Gather data from controller service object
        WelcomeMessage welcomeMessage = homeService.getWelcomeMessage();
        String specialAnnouncements = homeService.getSpecialAnnouncements();
        ArrayList<Movie> movieList = homeService.getNowShowingMovies();

        model.put("welcomeMessage", welcomeMessage);
        model.put("specialAnnouncements", specialAnnouncements);
        model.put("movieList", movieList);

        return "adminHome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String postAdminHome(ModelMap model) {
        HomeScreenService homeService = new HomeScreenService();
        return "adminHome";
    }

    @RequestMapping(value = "/admin/box-office", method = RequestMethod.GET)
    public String loadAdminBoxOffice(ModelMap model) {
        BoxOfficeScreenService boxOfficeService = new BoxOfficeScreenService();
        OperationHours opHours = boxOfficeService.getOperationHours();
        Admission admission = boxOfficeService.getAdmissionInfo();
        Notice notice = boxOfficeService.getNotice();

        model.put("opHours", opHours);
        model.put("admission", admission);
        model.put("notice", notice);

        return "adminBoxOffice";
    }

    @RequestMapping(value = "/admin/box-office", method = RequestMethod.POST)
    public String postAdminBoxOffice(ModelMap model) {

        return "adminBoxOffice";
    }    

    @RequestMapping(value = "/admin/concession", method = RequestMethod.GET)
    public String loadConcessionItems(ModelMap model) {
        model.addAttribute("testData", concessionService.getSaleItemsList());
        return "adminConcession";
    }

    @RequestMapping(value = "/admin/concession", method = RequestMethod.POST)
    public String postConcessionItems(ModelMap model) {
        model.addAttribute("testData", concessionService.postSaleItemsList());
        return "adminConcession";
    } 
    
    @RequestMapping(value = "/admin/about-us", method = RequestMethod.GET)
    public String loadAdminAboutUs(ModelMap model) {
        return "adminAboutUs";
    }

    @RequestMapping(value = "/admin/about-us/postAboutUs", method = RequestMethod.POST)
    public String postAdminAboutUs(ModelMap model) {
        
        return "adminAboutUs";
    }

    @RequestMapping(value = "/admin/footer", method = RequestMethod.GET)
    public String loadAdminFooter(ModelMap model) {
        return "adminFooter";
    }

    @RequestMapping(value = "/admin/footer", method = RequestMethod.POST)
    public String postAdminFooter(ModelMap model) {
        return "adminFooter";
    }
}