package com.example.demo.controller;

import com.example.demo.model.BloodDonation;
import com.example.demo.model.User;
import com.example.demo.service.BloodDonationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j      //various logging frameworks
@Controller
@SessionAttributes("userSession")
public class BloodDonationController {

    @Autowired
    BloodDonationService servicempl;

    @RequestMapping(value = "/my_blood_list")    //내 헌혈증 전체보기
    public String bloodList(Model uiModel, HttpServletRequest httpServlet){
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        List<BloodDonation> bdList = servicempl.findIdAndCheck(userSession.getUser(), (byte) 0);      //내 헌혈증 중 사용하지 않은(bdCheck==0) 헌혈증 가져오기
        uiModel.addAttribute("List", bdList);

        return "my_blood_list";
    }

    @RequestMapping(value = "/blood_detail/{bdId}")               //reqId에 대한 상세요청글 보기(작성자 시점)
    public String bloodDetail(@PathVariable("bdId") String bdId, Model uiModel){
        BloodDonation bloodDonation=servicempl.findByBdId(bdId);
        uiModel.addAttribute("bd", bloodDonation);
        return "blood_detail";
    }

    @GetMapping(value = "/blood_issue")      //헌혈증 발급 페이지 불러오기
    public String issue(Model uiModel, HttpServletRequest httpServlet){

        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        User user=userSession.getUser();
        uiModel.addAttribute("user", user);

        return "blood_issue";
    }

    @PostMapping(value = "/blood_issue")     //헌혈증 발급 페이지에서 작성 후 저장, 내 헌혈증 리스트 페이지로 이동
    public String issue(BloodDonation bloodDonation, Model uiModel, HttpServletRequest httpServlet){


        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        bloodDonation.setUser(userSession.getUser());                             //현재 user 정보 받아옴
        bloodDonation.getUser().setUserId(bloodDonation.getUser().getUserId());
        servicempl.saveBlood(bloodDonation);
        BloodDonation bd=servicempl.findByBdId(bloodDonation.getBdId());
        uiModel.addAttribute("blood",bd);
        return "redirect:/my_blood_list";
    }



}
