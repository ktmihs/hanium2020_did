package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.BloodDonationService;
import com.example.demo.service.DonateService;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
public class DonateController {

    @Autowired
    DonateService servicempl;
    @Autowired
    RequestService rServicempl;
    @Autowired
    BloodDonationService bdServicempl;

/*
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

 */

    @RequestMapping(value = "/donate_enroll/{reqId}")      //기부글 작성 페이지 불러오기
    public String enroll(@PathVariable("reqId") Integer reqId,User user, Model uiModel){

        Request request=rServicempl.findByReqId(reqId);//donate에 reqId저장하기(성공)
        uiModel.addAttribute("requestEnl", request);

        List<BloodDonation> bdList=bdServicempl.findAll();      //내 헌혈증 리스트 부르기(성공)
        uiModel.addAttribute("bdList",bdList);

        /*
        BloodDonation b=new BloodDonation();
        User u=new User();
        u=b.getUser();

        if (user.getUserId()=="980518") {
            List<BloodDonation> bdList = bdServicempl.findIdAndCheck(user, (byte) 0);
            uiModel.addAttribute("bdList", bdList);
        }

         */
        return "donate_enroll";
    }

    @PostMapping(value = "/donate_enroll/{reqId}")     //기부글 작성 페이지에서 작성 후 저장, 요청리스트 페이지로 이동
    public String enroll(@PathVariable("reqId") Integer reqId,Donate donate, Model uiModel){

        //DonateId dId=donate.getDonateId();
        //dId.setReqId(reqId);
        //Request request=rServicempl.findByReqId(dId.getReqId());//donate에 reqId저장하기
        //uiModel.addAttribute("requestEnl", request);
        donate.getRequest().setReqId(reqId);
        donate.getUser().setUserId("980518");
        donate.setDonateAmount(10);
        servicempl.save(donate);                                //기부 내역 저장

        //Donate don=servicempl.findByDonateId(donate.getDonateId());
        //uiModel.addAttribute("donateEnroll",don);
        uiModel.addAttribute("donateEnroll",donate);
        return "redirect:/request_detail_donor";
    }
//requestEnl->reqId로 req정보 받기, donateEnl->헌혈증 리스트 전부 출력

    @RequestMapping(value = "/request_detail_donor/{reqId}")      //기부글 작성 페이지 불러오기
    public String detailDonor(@PathVariable("reqId") Integer reqId, Model uiModel){

        Request request=rServicempl.findByReqId(reqId);//donate에 reqId저장하기(성공)
        uiModel.addAttribute("req", request);

        return "request_detail_donor";
    }



}
