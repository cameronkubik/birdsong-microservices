package com.birdsong.application.controller;

// import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    // @Autowired
    // private Db2Manager dbManager = new Db2Manager();

    // @RequestMapping("/content/get-home-screen")
    // public HomeScreenContent getHomeScreenContent() {
    //     dbManager.initializeConnection();

    //     HomeScreenContent homeScreen = new HomeScreenContent(dbManager);

    //     return homeScreen;
    // }

    // @RequestMapping("/content/get-box-office-screen")
    // public BoxOfficeScreenContent getBoxOfficeScreenContent() {
    //     dbManager.initializeConnection();

    //     BoxOfficeScreenContent boxOfficeContent = new BoxOfficeScreenContent(dbManager);
        
    //     return boxOfficeContent;
    // }

    // @RequestMapping("/content/get-concession-screen")
    // public ArrayList<ConcessionItem> getConcessionScreenContent() {
    //     dbManager.initializeConnection();
    //     ConcessionScreenContent concessionScreen = new ConcessionScreenContent(dbManager);
    //     return concessionScreen.concessionList;
    // }

    // // @RequestMapping("/content/get-about-us-screen")
    // // public AboutUsScreenContent getAboutUsScreenContent() {
    // //     dbManager.initializeConnection();
    // //     AboutUsScreenContent aboutUsContent = new AboutUsScreenContent(dbManager);
    // //     return aboutUsContent;
    // // }

    // @RequestMapping("/content/get-footer-screen")
    // public FooterContent getFooterContent() {
    //     return new FooterContent("", (long) 1, "", "", "", "", 0);
    // }
}