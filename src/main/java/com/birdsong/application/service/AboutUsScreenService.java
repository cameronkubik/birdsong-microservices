package com.birdsong.application.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;

import com.birdsong.application.model.*;
import com.birdsong.application.service.Db2Manager;

@Service
public class AboutUsScreenService {

    private Db2Manager dbManager = new Db2Manager();

    static {
        //System.out.print("Any static logic can be executed here...");
    }

    public AboutUsContent getAboutUs() {
        AboutUsContent aboutUsContent = dbManager.getAboutUsContent();
        return aboutUsContent;
    }
}