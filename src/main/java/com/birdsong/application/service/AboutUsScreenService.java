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

    public AboutUsContent getAboutUs() {
        AboutUsContent aboutUsContent = dbManager.getAboutUsContent();
        return aboutUsContent;
    }

    public boolean postAboutUs(AboutUsContent _content) {
        dbManager.postAboutUs(_content);
        return false;
    }
}