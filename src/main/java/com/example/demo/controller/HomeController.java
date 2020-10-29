package com.example.demo.controller;

        import lombok.extern.slf4j.Slf4j;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HomeController {


    @RequestMapping("/index")
    public String viewIndexPage() {

        return "index";
    }
    @RequestMapping("/login")
    public String viewLoginPage() {

        return "login";
    }

    @RequestMapping("/enroll")
    public String viewEnrollPage() {

        return "my_blood_list";
    }
    @RequestMapping("/donate")
    public String viewDonatePage() {

        return "request_list";
    }
    @RequestMapping("/profile")
    public String viewProfilePage() {

        return "profile";
    }
}
