package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DonateController {

    @RequestMapping("/request_detail_user")
    public String viewRequest_detail_userPage() {

        return "request_detail_user";
    }
    @RequestMapping("/request_detail_writer")
    public String viewRequest_detail_writerPage() {

        return "request_detail_writer";
    }
    @RequestMapping("/request_detail_donor")
    public String viewRequest_detail_donorPage() {

        return "request_detail_donor";
    }
    @RequestMapping("/request_enroll")
    public String viewRequest_enrollPage() {

        return "request_enroll";
    }
    @RequestMapping("/donate_enroll")
    public String viewDonate_enrollPage() {

        return "donate_enroll";
    }
}
