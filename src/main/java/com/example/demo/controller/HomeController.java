package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@SessionAttributes("userSession")
public class HomeController {


    @RequestMapping("/")
    public String viewMainPage() {
        return "index";
    }
    @RequestMapping("/index")
    public String viewIndexPage() {             //메인 페이지

        return "index";
    }
    @RequestMapping("/index_login")
    public String viewIndexLoginPage() {             //메인 페이지

        return "index_login";
    }

    @RequestMapping("/enroll_com")
    public String viewEnrollComPage() {

        return "enroll_com";
    }
    @RequestMapping("/enroll_res")
    public String viewEnrollResPage() {

        return "enroll_res";
    }
    @RequestMapping("/profile_pre")                 //마이페이지
    public String viewProfilePrePage() {

        return "profile_pre";
    }

}
