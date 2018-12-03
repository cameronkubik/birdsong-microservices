package com.birdsong.application.service;

import org.springframework.stereotype.Service;

import com.birdsong.application.model.*;
import com.birdsong.application.service.Db2Manager;

@Service
public class AboutUsScreenService {

    private Db2Manager dbManager = Db2Manager.getInstance();

    static {
        //System.out.print("Any static logic can be executed here...");
    }

    public String getHeaderFromDb() {
        return "About Us";
    }

    public String getSubHeaderFromDb() {
        return "Movies are our passion!";
    }

    public String getBodyFromDb() {
        return "Our goal is to provide you a clean, comfortable and friendly atmosphere for the entire family to enjoy. We have stadium type parking, a 30' x 60' screen with stereo sound, concession and clean rest room facilities.";
    }
    public AboutUsContent getAboutUs() {
        AboutUsContent aboutUsContent = dbManager.getAboutUsContent();
        return aboutUsContent;
    }

    public boolean postAboutUs(AboutUsContent _content) {
        System.out.print(_content);
        return false;
    }
}