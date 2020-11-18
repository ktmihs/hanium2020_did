package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.BloodDonationService;
import com.example.demo.service.DonateService;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@SessionAttributes("userSession")
public class DonateController {

    @Autowired
    DonateService servicempl;
    @Autowired
    RequestService rServicempl;
    @Autowired
    BloodDonationService bdServicempl;

    //요청글에 대한 기부글 작성
    @RequestMapping(value = "/donate_enroll/{reqId}")
    public String enroll(@PathVariable("reqId") Integer reqId,
                         BloodDonation bloodDonation, Model uiModel,Donate donate, HttpServletRequest httpServlet){
        Request request=rServicempl.findByReqId(reqId);         //donate에 reqId저장하기
        uiModel.addAttribute("requestEnl", request);
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        List<BloodDonation> bdList = bdServicempl.findIdAndCheck(userSession.getUser(), 0);
                                                        //내 헌혈증 중 사용하지 않은(bdCheck==0) 헌혈증 가져오기
        uiModel.addAttribute("bdList", bdList);
        return "donate_enroll";
    }

    @PostMapping(value = "/donate_enroll/{reqId}")     //기부글 작성 페이지에서 작성 후 저장, 요청리스트 페이지로 이동
    public String enroll(@PathVariable("reqId") Integer reqId, String[] bdId,
                         Donate donate, HttpServletRequest httpServlet){
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        Request request=rServicempl.findByReqId(reqId);
        donate.setUser(userSession.getUser());                  //현재 user 정보 받아옴(로그인 한 유저의 정보)
        donate.setRequest(request);                             //request 정보 저장(기부하려는 요청글 정보)
        donate.setDonateAmount(bdId.length);                    //기부할 헌혈증 개수 저장
        int amount = request.getReqTotal() + bdId.length;   //현재 기부된 숫자에 기부하는 헌혈증 개수를 더해줌
        donate.getRequest().setReqTotal(amount);
        servicempl.bdSave(donate);                                //기부 내역 저장

        for(int i=0;i<bdId.length;i++){                        //view로부터 받아온 기부 선택한 헌혈증 정보 변경
            BloodDonation bloodDonation = bdServicempl.findByBdId(bdId[i]);     //헌혈증 id로 불러옴
            bloodDonation.setBdCheck(1);                        //bdCheck를 1로 변경(0:기본 1:기부)
            bloodDonation.setBdDonate(request.getUser().getUserId());   //bdDonate(기부받은 userId)에 현재 요청 userId 저장
        }
        return "redirect:/request_list";
    }

    //기부한 리스트 전체보기
    @RequestMapping("/donate_mylist")
    public String ListDonate(Model uiModel, HttpServletRequest httpServlet) {
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        List<Donate> donate = servicempl.findAllByUser(userSession.getUser());      //기부내역 리스트 받아오기
        uiModel.addAttribute("donate", donate);
        return "donate_mylist";
    }

}
