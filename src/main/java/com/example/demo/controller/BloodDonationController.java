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

    //헌혈증 발급
    @GetMapping(value = "/blood_issue")      //헌혈증 발급 페이지 불러오기
    public String issue(Model uiModel, HttpServletRequest httpServlet){
        //현재 로그인 된 세션정보 가져오기
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        User user=userSession.getUser();
        uiModel.addAttribute("user", user);  //로그인 된 유저 정보("user")를 blood_issue로 넘겨줌
        return "blood_issue";
    }
    @PostMapping(value = "/blood_issue")     //헌혈증 발급 페이지에서 작성 후 저장, 내 헌혈증 리스트 페이지로 이동
    public String issue(BloodDonation bloodDonation, Model uiModel, HttpServletRequest httpServlet){

        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        bloodDonation.setUser(userSession.getUser());                             //현재 user 정보 받아옴
        bloodDonation.getUser().setUserId(bloodDonation.getUser().getUserId());   //userId를 넣어줌
        servicempl.saveBlood(bloodDonation);                                      //헌혈증 생성(DB에 저장)
        BloodDonation bd=servicempl.findByBdId(bloodDonation.getBdId());          //헌혈증 ID 검색
        uiModel.addAttribute("blood",bd);                                      //blood_issue에서 "blood"를 통해 정보 받기
        return "redirect:/my_blood_list";                                         //완료 후 my_blood_list 페이지로 이동
    }

    //헌혈증 상세요청글 보기
    @RequestMapping(value = "/blood_detail/{bdId}")
    public String bloodDetail(@PathVariable("bdId") String bdId, Model uiModel){
        BloodDonation bloodDonation=servicempl.findByBdId(bdId);
        uiModel.addAttribute("bd", bloodDonation);
        return "blood_detail";
    }

    //내 헌혈증 리스트 전체 보기
    @RequestMapping(value = "/my_blood_list")
    public String bloodList(Model uiModel, HttpServletRequest httpServlet){
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        List<BloodDonation> bdList = servicempl.findIdAndCheck(userSession.getUser(), 0);      //내 헌혈증 중 사용하지 않은(bdCheck==0) 헌혈증 가져오기
        uiModel.addAttribute("List", bdList);

        return "my_blood_list";
    }

    //기부받은 헌혈증 전체보기
    @RequestMapping(value = "/get_blood_list")
    public String getBloodList(Model uiModel, HttpServletRequest httpServlet){
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        List<BloodDonation> bdList = servicempl.findByBdDoneAndBDC(userSession.getUser().getUserId(),1);  // 기부된 헌혈증 중 내게 기부된 헌혈증 리스트 가져오기
        uiModel.addAttribute("List", bdList);

        return "get_blood_list";
    }
}
