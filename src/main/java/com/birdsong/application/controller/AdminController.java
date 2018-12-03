package com.birdsong.application.controller;


import com.birdsong.application.service.*;

import java.util.ArrayList;

import javax.validation.Valid;

import com.birdsong.application.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    private Db2Manager dbManager = Db2Manager.getInstance();

    // Pre load Classes for spring boot
    @Autowired
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
        BoxOfficeScreenService boxOfficeService = new BoxOfficeScreenService();
        return "adminBoxOffice";
    }    

    @RequestMapping(value = "/admin/concession", method = RequestMethod.GET)
    public String loadConcessionItems(ModelMap model) {
        ConcessionScreenService concessionService = new ConcessionScreenService();
        model.addAttribute("testData", concessionService.getSaleItemsList());
        return "adminConcession";
    }

    @RequestMapping(value = "/admin/concession", method = RequestMethod.POST)
    public String postConcessionItems(ModelMap model) {
        ConcessionScreenService concessionService = new ConcessionScreenService();
        model.addAttribute("testData", concessionService.postSaleItemsList());
        return "adminConcession";
    } 
    
    @RequestMapping(value = "/admin/about-us", method = RequestMethod.GET)
    public ModelAndView loadAdminAboutUs() {
        return new ModelAndView("adminAboutUs", "aboutUsContent", new AboutUsContent());
    }

    @RequestMapping(value = "/admin/post-about-us", method = RequestMethod.POST)
    public String postAdminAboutUs(@Valid @ModelAttribute("aboutUsContent") AboutUsContent aboutUsContent, 
            BindingResult result, ModelMap model) {
        AboutUsScreenService aboutUsService = new AboutUsScreenService();

        model.addAttribute("header", aboutUsContent.getHeader());
        model.addAttribute("subHeader", aboutUsContent.getSubHeader());
        model.addAttribute("body", aboutUsContent.getBody());
        
        return "adminAboutUs";
    }

    @RequestMapping(value = "/admin/footer", method = RequestMethod.GET)
    public ModelAndView loadAdminFooter() {
        return new ModelAndView("adminFooter", "footerContent", new Footer());
    }

    @RequestMapping(value = "/admin/post-footer", method = RequestMethod.POST)
    public String postAdminFooter(@Valid @ModelAttribute("footerContent") Footer footer,
            BindingResult result, ModelMap model) {
        FooterService service = new FooterService();

        model.addAttribute("address", footer.getAddress());
        model.addAttribute("address2", footer.getAddress2());
        model.addAttribute("city", footer.getCity());
        model.addAttribute("state", footer.getState());
        model.addAttribute("zip", footer.getZip());
        model.addAttribute("email", footer.getEmail());
        model.addAttribute("phone", footer.getPhone());
        model.addAttribute("twitter", footer.getTwitter());
        model.addAttribute("facebook", footer.getFacebook());
        model.addAttribute("instagram", footer.getInstagram());
        model.addAttribute("youtube", footer.getYoutube());

        service.postFooterData(footer);
        
        return "adminFooter";
    }
}