package com.birdsong.application.controller;

import com.birdsong.application.model.OperationHours;
import com.birdsong.application.model.Admission;
import com.birdsong.application.model.Notice;
import com.birdsong.application.service.BoxOfficeScreenService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoxOfficeScreenController {

    @Autowired
    BoxOfficeScreenService service = new BoxOfficeScreenService();

    @RequestMapping(value="/box-office", method = RequestMethod.GET)
    public String loadBoxOffice(ModelMap model) {
        OperationHours opHours = service.getOperationHours();
        Admission admission = service.getAdmissionInfo();
        Notice notice = service.getNotice();

        model.put("opHours", opHours);
        model.put("admission", admission);
        model.put("notice", notice);
        
        return "boxOfficeScreen";
    }
}