package com.example.demo.controller;

import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.repository.RequestRepository;
import com.example.demo.repository.UserRepository;
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
    @Autowired
    UserRepository userRepository;
    @Autowired
    RequestRepository requestRepository;

    @RequestMapping(value = "/request_list")    //paging한 요청글 전체보기
    public String list(Model uiModel,
                       @PageableDefault(sort={"reqId"},direction = Sort.Direction.DESC,size=6) Pageable pageable){    //한 페이지 당 6개씩
        Page<Request> requestList=servicempl.findAll(pageable);     //jpaRepository의 findAll함수를 사용
        uiModel.addAttribute("List",requestList);
        return "request_list";
    }
    /*
    @RequestMapping(value = "/request_list")        //paging 안 했을 때
    public String list(Model uiModel){
        List<Request> requestList=servicempl.findAll();
        uiModel.addAttribute("List",requestList);
        System.out.println(requestList);
        return "request_list";
    }
     */

    @RequestMapping("/request_mylist")
    public String viewRequestMylistPage(Model uiModel,  HttpServletRequest httpServlet) {
        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        String userId =userSession.getUser().getUserId();

//        userId = "U00001";
        //user 정보에 따른 요청내역
        User user = userRepository.findByUserId(userId);

        List<Request> requests = requestRepository.findAllByUser(user);

        uiModel.addAttribute("requests", requests);

        return "request_mylist";
    }


    @GetMapping(value = "/request_enroll")      //요청글 작성 페이지 불러오기
    public String enroll(Model uiModel, HttpServletRequest httpServlet){

        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        String groupName=userSession.getUser().getGroup().getgName();
        uiModel.addAttribute("groupName", groupName);

        return "request_enroll";
    }

    @PostMapping(value = "/request_enroll")     //요청글 작성 페이지에서 작성 후 저장, 요청리스트 페이지로 이동
    public String enroll(Request request, Model uiModel, HttpServletRequest httpServlet){
        servicempl.createRequest(request);

        UserSession userSession = (UserSession) WebUtils.getSessionAttribute(httpServlet, "userSession");
        request.setUser(userSession.getUser());                             //현재 user 정보 받아옴

        request.setReqDeadline(request.getReqDeadline().plusDays(1));       //날짜가 전날로 나와서 +1해줌
        Request req=servicempl.findByReqId(request.getReqId());
        uiModel.addAttribute("enrollList",req);
        return "redirect:/request_list";
    }

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

    @DeleteMapping("/request_detail_donor/{reqId}")
    public String detailDonor(@PathVariable("reqId") Integer reqId){
        servicempl.deleteOne(reqId);
        return "request_detail_donor";
    }
}
