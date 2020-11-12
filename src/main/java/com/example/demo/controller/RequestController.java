package com.example.demo.controller;

import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.repository.RequestRepository;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
//import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class RequestController {

    @Autowired
    RequestService servicempl;
    @Autowired
    RequestRepository requestRepo;

    @Autowired
    public void setRequestService(RequestService requestService) {
        this.servicempl = requestService;
    }
    @Autowired
    public void setRequestRepository(RequestRepository requestRepository) {
        this.requestRepo = requestRepository;
    }
    @Autowired
    public RequestService getRequestService(){
        return servicempl;
    }
    @Autowired
    public RequestRepository getRequestRepository(){
        return requestRepo;
    }


    @RequestMapping(value = "/request_list")    //paging한 요청글 전체보기
    public String list(Model uiModel,@PageableDefault(sort={"reqId"},direction = Sort.Direction.DESC,size=6) Pageable pageable){    //한 페이지 당 6개씩
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

/*
    @GetMapping("/request_enroll")                  //헌혈증 요청 작성 페이지 가져오기
    @ResponseBody
    public ModelAndView viewRequestEnrollPage() {
        ModelAndView nextView=new ModelAndView("request_enroll");
        return nextView;
    }

    @PostMapping("/request_enroll")                 //헌혈증 요청 작성 페이지 저장하기 -> uiModel로 변경해서 다시하기
    @ResponseBody
    public ModelAndView viewRequestEnrollPage(Request request){
        servicempl.createRequest(request);
        ModelAndView nextView=new ModelAndView("request_detail_writer");
        List<Request> list= (List<Request>) servicempl.findByReqId(request.getReqId());
        nextView.addObject("requestList",list);
        return nextView;
    }

 */

    @GetMapping(value = "/request_enroll")
    public String enroll(){
        return "request_enroll";
    }
    @PostMapping(value = "/request_enroll")
    public String enroll(Request request, Model uiModel){
        servicempl.createRequest(request);
        Request req=servicempl.findByReqId(request.getReqId());
        uiModel.addAttribute("enrollList",req);
        return "request_list";
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

/*
    @RequestMapping("/request_detail_writer/{reqId}")      //요청 내역 중 하나 클릭해서 들어갔을 떄 페이지
    public String viewRequestDetailWriterPage(@PathVariable("reqId") String reqId, Model uiModel) {
        Request req=requestRepo.findByReqId(reqId);
        //System.out.println(reqId);
        uiModel.addAttribute("RequestL",req);
//        ModelAndView nextView=new ModelAndView("/request_detail_writer/{reqId}");
//        nextView.addObject("RequestL", req);
        return "request_detail_writer";
    }
 */
}
