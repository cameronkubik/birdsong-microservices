package com.birdsong.application.controller;

import com.birdsong.application.service.HomeService;

import javax.validation.Valid;

import com.birdsong.application.model.HomeContent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    HomeService service = new HomeService();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadHomeContent(ModelMap model) {
        HomeContent latestContent = service.getHomeContent();
        model.put("content", latestContent);
        return "home";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView loadAdminAboutUs() {
        return new ModelAndView("homeAdmin", "homeContent", new HomeContent());
    }

    @RequestMapping(value = "/admin/post-home", method = RequestMethod.POST)
    public String postAdminHome(@Valid @ModelAttribute("homeContent") HomeContent content,
            BindingResult result, ModelMap model) {
        service.post(content);

        model.put("homeContent", content);
        return "homeAdmin";
    }

}