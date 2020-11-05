package com.example.demo.controller;

        import lombok.extern.slf4j.Slf4j;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HomeController {


    @RequestMapping("/")
    public String viewMainPage() {

        return "index";
    }
    @RequestMapping("/index")
    public String viewIndexPage() {

        return "index";
    }
    @RequestMapping("/login")
    public String viewLoginPage() {

        return "login";
    }

    @RequestMapping("/my_blood_list")
    public String viewMyBloodListPage() {

        return "my_blood_list";
    }

    @RequestMapping("/profile")
    public String viewProfilePage() {

        return "profile";
    }
}
