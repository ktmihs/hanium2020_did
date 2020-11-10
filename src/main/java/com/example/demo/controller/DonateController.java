package com.example.demo.controller;

import com.example.demo.model.Donate;
import com.example.demo.service.DonateService;
import com.example.demo.service.DonateServicempl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

//    @RequestMapping("/request_detail_donor")        //선택한 페이지 상세보기
//    public String viewRequestDetailDonorPage() {
//
//        return "request_detail_donor";
//    }

    @GetMapping("/donate_enroll")                   //기부 페이지 가져오기
    public ModelAndView viewDonateEnrollPage(){
        ModelAndView nextView=new ModelAndView("/donate_enroll");
        return nextView;
    }
    @PostMapping("/donate_enroll")                  //기부 페이지 저장하기
    public ModelAndView viewDonateEnrollPage(Donate donate) {

        servicempl.createDonate(donate);
        ModelAndView nextView=new ModelAndView("/request_detail_user");
        List<Donate> list=servicempl.findAll();
        nextView.addObject("viewDonate_listPage",list);
        return nextView;
    }

    @GetMapping("/request_detail_donor/{donateId}")     //선택한 페이지 상세보기
    public ModelAndView viewRequestDetailDonorPage(@PathVariable("donateId") int donateId){
        Donate donate=servicempl.findByDonateId(donateId);
        ModelAndView nextView=new ModelAndView("/request_detail_donor");
        nextView.addObject("Donate", donate);
        return nextView;
    }

}
