package com.example.demo.controller;

import com.example.demo.model.Donate;
import com.example.demo.service.DonateService;
import com.example.demo.service.DonateServicempl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class DonateController {

    @Autowired
    DonateService servicempl;

    @RequestMapping("/request_detail_donor")
    public String viewRequestDetailDonorPage() {

        return "request_detail_donor";
    }

    @RequestMapping("/donate_enroll")
    public ModelAndView viewDonateEnrollPage(){
        ModelAndView nextView=new ModelAndView("/donate_enroll");
        return nextView;
    }
    @PostMapping("/donate_enroll")
    public ModelAndView viewDonateEnrollPage(Donate donate) {

        servicempl.createDonate(donate);
        ModelAndView nextView=new ModelAndView("/request_detail_user");
        List<Donate> list=servicempl.findAll();
        nextView.addObject("viewDonate_listPage",list);
        return nextView;
    }

    @RequestMapping("/request_detail_donor/{donateId}")
    public ModelAndView viewRequestDetailDonorPage(@PathVariable("donateId") int donateId){
        Donate donate=servicempl.findByDonateId(donateId);
        ModelAndView nextView=new ModelAndView("/request_detail_donor");
        nextView.addObject("Donate", donate);
        return nextView;
    }

}
