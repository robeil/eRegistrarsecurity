package com.robeil.eregistrarsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/eRegistrar"})
public class LoginController {

    @GetMapping(value = {"/public/login"})
    public String login(){
        return "public/login";
    }
}
