package com.birdsong.application.service;

import org.springframework.stereotype.Service;

@Service
public class AboutUsScreenService {

    private String aboutUs;

    static {
        //System.out.print("Any static logic can be executed here...");
    }

    public AboutUsScreenService() {
        this.aboutUs = "Birdsong Drive-In theaters, located in Camden, TN.";
    }

    public String getAboutUs() {
        // make call to DB
        // ...logic...
        // assign to aboutUs
        return this.aboutUs;
    }
}