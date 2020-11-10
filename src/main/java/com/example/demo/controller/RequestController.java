package com.example.demo.controller;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class RequestController {

    @Autowired
    RequestService servicempl;
    @Autowired
    RequestRepository requestRepository;

    public RequestController(RequestService servicempl) {
        this.servicempl = servicempl;
    }

    /*
    @GetMapping("/request_list")                    //전체 요청내역 페이지
    @ResponseBody
    public ModelAndView viewRequestListPage() {
        List<Request> list=servicempl.findAll();
        ModelAndView nextView=new ModelAndView("request_list");
        nextView.addObject("requestList",list);
        return nextView;
    }
    */
    @RequestMapping("/donate_mylist")
    public String ListDonate(Model uiModel) {
        List<Request> list = servicempl.findAll();
        uiModel.addAttribute("requestList", list);
        return "request_list";
    }

    @GetMapping(value="/index")
    public Model ListRequest(Model uiModel) {
        List<Request> list = servicempl.findAll();
        uiModel.addAttribute("requestList", list);
        return uiModel;
    }

    @GetMapping("/request_enroll")                  //헌혈증 요청 작성 페이지 가져오기
    @ResponseBody
    public ModelAndView viewRequestEnrollPage() {
        ModelAndView nextView=new ModelAndView("request_enroll");
        return nextView;
    }

    @PostMapping("/request_enroll")                 //헌혈증 요청 작성 페이지 저장하기
    @ResponseBody
    public ModelAndView viewRequestEnrollPage(Request request){
        servicempl.createRequest(request);
        ModelAndView nextView=new ModelAndView("request_detail_writer");
        List<Request> list= (List<Request>) servicempl.findByReqId(request.getReqId());        //수정
        nextView.addObject("requestList",list);
        return nextView;
    }

    @GetMapping("/request_detail_user")             //요청 작성 페이지 완료 후 보이는 페이지
    @ResponseBody
    public String viewRequestDetailUserPage() {

        return "request_detail_user";
    }

//    @GetMapping("/request_detail_writer/{reqId}")      //요청 내역 중 하나 클릭해서 들어갔을 떄 페이지
//    @ResponseBody
//    public ModelAndView viewRequestDetailWriterPage(@PathVariable("reqId") String reqId) {
//        Request req=servicempl.findByReqId(reqId);

//        ModelAndView nextView=new ModelAndView("/request_detail_writer");
//        nextView.addObject("Request", req);
//        return nextView;
//    }

    @GetMapping("/request_detail_writer/{reqId}")
    public Request getPost(@PathVariable String reqId){
        //Long postID=Long.parseLong(reqId);
        Optional<Request> req= Optional.ofNullable(requestRepository.findByReqId(reqId));

        return req.get();
    }
}
