package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.DonateRepository;
import com.example.demo.service.BloodDonationService;
import com.example.demo.service.DonateService;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@SessionAttributes("userSession")
public class DonateController {

    @Autowired
    DonateService servicempl;
    @Autowired
    DonateRepository donateRepository;
    @Autowired
    RequestService rServicempl;
    @Autowired
    BloodDonationService bdServicempl;

    @RequestMapping("/donate_mylist")
    public String ListDonate(Model uiModel, HttpServletRequest httpServlet) {
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        String userId =userSession.getUser().getUserId();
        User user = userSession.getUser();

        // user 정보에 따른 기부 내역
        List<Donate> donate = donateRepository.findAllByUser(user);

        // donate 테이블의 reqId 에 따른 요청글 찾아서 웹으로 전달
        Request request;
        for(Donate don : donate){
            request = don.getRequest();
            List<Donate> donateB = donateRepository.findByRequest(request);
            uiModel.addAttribute("donateA", donateB);
        }
        return "donate_mylist";
    }



    @RequestMapping(value = "/donate_enroll/{reqId}")      //기부글 작성 페이지 불러오기
    public String enroll(@PathVariable("reqId") Integer reqId,
                         BloodDonation bloodDonation, Model uiModel,Donate donate, HttpServletRequest httpServlet){

        Request request=rServicempl.findByReqId(reqId);//donate에 reqId저장하기(성공)
        uiModel.addAttribute("requestEnl", request);

        //List<BloodDonation> bdList=bdServicempl.findAll();      //전체 헌혈증 리스트 부르기(성공)
        //uiModel.addAttribute("bdList",bdList);

        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        List<BloodDonation> bdList = bdServicempl.findIdAndCheck(userSession.getUser(), 0);      //내 헌혈증 중 사용하지 않은(bdCheck==0) 헌혈증 가져오기
        uiModel.addAttribute("bdList", bdList);

        return "donate_enroll";
    }

    @PostMapping(value = "/donate_enroll/{reqId}")     //기부글 작성 페이지에서 작성 후 저장, 요청리스트 페이지로 이동
    public String enroll(@PathVariable("reqId") Integer reqId, String[] bdId,
                         Donate donate, HttpServletRequest httpServlet){
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        Request request=rServicempl.findByReqId(reqId);
        donate.setUser(userSession.getUser());                  //현재 user 정보 받아옴
        donate.setRequest(request);                    //reqId 저장
        donate.setDonateAmount(bdId.length);
        servicempl.bdSave(donate);                                //기부 내역 저장

        for(int i=0;i<bdId.length;i++){
            System.out.println(bdId[i]);
            BloodDonation bloodDonation=bdServicempl.findByBdId(bdId[i]);
            bloodDonation.setBdCheck(1);                        //bdCheck를 1로 변경(0:기본 1:기부)
            bloodDonation.setBdDonate(request.getUser().getUserId());
            System.out.println(bdId[i]);
        }
        //System.out.println(donate);
        return "redirect:/request_list";
    }

    @RequestMapping(value = "/request_detail_donor/{reqId}")      //기부글 작성 페이지 불러오기
    public String detailDonor(@PathVariable("reqId") Integer reqId, Model uiModel){

        Request request=rServicempl.findByReqId(reqId);//donate에 reqId저장하기(성공)
        uiModel.addAttribute("req", request);

        return "request_detail_donor";
    }



}
