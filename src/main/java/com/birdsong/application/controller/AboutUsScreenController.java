package com.birdsong.application.controller;

import com.birdsong.application.service.AboutUsScreenService;
import com.birdsong.application.model.*;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutUsScreenController {

    @Autowired
    AboutUsScreenService service = new AboutUsScreenService();

    @RequestMapping(value = "/about-us", method = RequestMethod.GET)
    public String loadAboutUs(ModelMap model) {
        AboutUsContent content = service.getAboutUs();
        model.put("content", content);
        return "aboutUsScreen";
    }

    // @RequestMapping(value = "/change-about-us", method = RequestMethod.POST)
    // public String changeAboutUs(@ModelAttribute("content")AboutUsContent content, ModelMap model) {
    //     model.addAttribute("subHeader", content.getSubHeader());
    //     model.addAttribute("body", content.getBody());
    //     service.postAboutUs(content);
    //     return "adminAboutUs";
    // }

    // @RequestMapping(value = "/admin/about-us", method = RequestMethod.GET)
    // public String loadAboutUsAsAdmin(@ModelAttribute("content")AboutUsContent content,
    // ModelMap model) {
    // model.addAttribute("subHeader", content.getSubHeader());
    // model.addAttribute("body", content.getBody());
    // service.postAboutUs(content);
    // return "adminAboutUs";
    // }
}