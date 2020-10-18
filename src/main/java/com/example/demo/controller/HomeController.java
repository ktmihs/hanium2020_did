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
    @RequestMapping("/tables")
    public String viewTablesPage() {

        return "tables";
    }

    @RequestMapping("/charts")
    public String viewchartsPage() {

        return "charts";
    }
    @RequestMapping("/enroll_com")
    public String viewenroll_comPage() {

        return "enroll_com";
    }
    @RequestMapping("/enroll_res")
    public String viewenroll_resPage() {

        return "enroll_res";
    }
}
