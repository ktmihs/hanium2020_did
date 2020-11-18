package com.example.demo.controller;

import com.example.demo.model.Request;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j      //various logging frameworks
@Controller
@SessionAttributes("userSession")
public class RequestController {

    @Autowired
    RequestService servicempl;


    //기부요청글 작성하기
    @GetMapping(value = "/request_enroll")      //요청글 작성 페이지 불러오기
    public String enroll(Model uiModel, HttpServletRequest httpServlet){
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        String groupName=userSession.getUser().getGroup().getgName();       //그룹 구분(일반인지 기관인지)하여 표시
        uiModel.addAttribute("groupName", groupName);                    //view로 넘겨서 사용함

        return "request_enroll";
    }

    @PostMapping(value = "/request_enroll")     //요청글 작성 페이지에서 작성 후 저장, 요청리스트 페이지로 이동
    public String enroll(Request request, Model uiModel, HttpServletRequest httpServlet){
        servicempl.createRequest(request);                                  //현재 작성된 데이터 저장
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        request.setUser(userSession.getUser());                             //현재 user 정보 받아옴
        request.setReqDeadline(request.getReqDeadline().plusDays(1));
        Request req=servicempl.findByReqId(request.getReqId());
        uiModel.addAttribute("enrollList",req);
        return "redirect:/request_list";
    }

    //전체 요청글 리스트 보여주기
    @RequestMapping(value = "/request_list")    //paging한 요청글 전체보기
    public String list(Model uiModel,
                       @PageableDefault(sort={"reqId"},direction = Sort.Direction.DESC,size=5) Pageable pageable){    //한 페이지 당 6개씩
        Page<Request> requestList=servicempl.findAll(pageable);     //jpaRepository의 findAll함수를 사용
        uiModel.addAttribute("List",requestList);
        return "request_list";
    }

    //내가 요청한 기부요청글 리스트
    @RequestMapping(value = "/request_mylist")              //내 요청 리스트 보기
    public String requestMyList(Model uiModel, HttpServletRequest httpServlet) {
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        List<Request> requests = servicempl.findAllByUser(userSession.getUser());
        uiModel.addAttribute("requests", requests);

        return "request_mylist";
    }

    //주체별 상세요청글 보기
    @RequestMapping(value = "/request_detail_writer/{reqId}")               //reqId에 대한 상세요청글 보기(작성자 시점)
    public String detailWriter(@PathVariable("reqId") Integer reqId, Model uiModel){
        Request request=servicempl.findByReqId(reqId);
        uiModel.addAttribute("req", request);
        return "request_detail_writer";
    }

    @RequestMapping(value = "/request_detail_user/{reqId}")               //reqId에 대한 상세요청글 보기(일반 사용자 시점)
    public String detailUser(@PathVariable("reqId") Integer reqId, Model uiModel){
        Request request=servicempl.findByReqId(reqId);
        uiModel.addAttribute("req", request);
        return "request_detail_user";
    }

    @RequestMapping(value = "/request_detail_donor/{reqId}")               //reqId에 대한 상세요청글 보기(기부자 시점)
    public String detailDonor(@PathVariable("reqId") Integer reqId, Model uiModel){
        Request request=servicempl.findByReqId(reqId);
        uiModel.addAttribute("req", request);
        return "request_detail_donor";
    }

    /*
    @RequestMapping(value = "/request_list")        //paging 안 했을 때 전체 리스트
    public String list(Model uiModel){
        List<Request> requestList=servicempl.findAll();
        uiModel.addAttribute("List",requestList);
        System.out.println(requestList);
        return "request_list";
    }
     */
}