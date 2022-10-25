package com.robeil.eregistrarsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class HomeController {

    @GetMapping(value = {"/", "/home","/eRegistrar/public/home"})
    public String displayHomepage() {
        return "public/index";
    }

    @GetMapping(value = {"/eRegistrar/public/about"})
    public String displayAboutPage() {
        return "public/about";
    }


}
