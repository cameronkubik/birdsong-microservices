package com.birdsong.application.service;

import org.springframework.stereotype.Service;

@Service
public class BoxOfficeScreenService {

    private String ticketPrice;

    static {
        // System.out.print("Any static logic can be executed here...");
    }

    public BoxOfficeScreenService() {
        this.ticketPrice = "$10";
    }

    public String getAboutUs() {
        // make call to DB
        // ...logic...
        // assign to ticketPrice
        return this.ticketPrice;
    }
}