package com.birdsong.application.controller;

import com.birdsong.application.model.OperationHours;

import javax.validation.Valid;

import com.birdsong.application.model.Admission;
import com.birdsong.application.model.BoxOfficeContent;
import com.birdsong.application.model.Notice;
import com.birdsong.application.service.BoxOfficeService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoxOfficeController {

    @Autowired
    BoxOfficeService service = new BoxOfficeService();

    @RequestMapping(value="/box-office", method = RequestMethod.GET)
    public String loadBoxOffice(ModelMap model) {
        BoxOfficeContent content = service.getContent();

        model.put("content", content);
        
        return "boxOffice";
    }

    @RequestMapping(value = "/admin/box-office", method = RequestMethod.GET)
    public ModelAndView loadAdminBoxOffice() {
        return new ModelAndView("boxOffice", "content", new BoxOfficeContent());
    }

    @RequestMapping(value = "/admin/post-box-office", method = RequestMethod.POST)
    public String postAdminBoxOffice(@Valid @ModelAttribute("content") BoxOfficeContent content, BindingResult result,
            ModelMap model) {
        service.post(content);

        model.put("content", content);
        return "boxOfficeAdmin";
    }
}