package com.birdsong.application.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;

import com.birdsong.application.model.*;
import com.birdsong.application.service.Db2Manager;

// Service for Model
@Service
public class FooterService {

    private Db2Manager dbManager = Db2Manager.getInstance();

    public String get() {
        return "todo";
    }

}