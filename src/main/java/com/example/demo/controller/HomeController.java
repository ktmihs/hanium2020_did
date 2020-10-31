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

    @RequestMapping("/enroll")
    public String viewEnrollPage() {

        return "my_blood_list";
    }
    @RequestMapping("/request_list")
    public String viewRequest_listPage() {

        return "request_list";
    }
    @RequestMapping("/profile")
    public String viewProfilePage() {

        return "profile";
    }
    @RequestMapping("/request_detail_donor")
    public String viewRequest_detail_donorPage() {

        return "request_detail_donor";
    }
    @RequestMapping("/my_blood_list")
    public String viewMy_blood_listPage() {

        return "my_blood_list";
    }
}
