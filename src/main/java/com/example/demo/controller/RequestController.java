package com.example.demo.controller;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class RequestController {

    @Autowired
    RequestService servicempl;
    @Autowired
    RequestRepository requestRepository;

    @GetMapping("/request_list")
    @ResponseBody
    public ModelAndView viewRequestListPage() {
        List<Request> list=servicempl.findAll();
        ModelAndView nextView=new ModelAndView("request_list");
        nextView.addObject("requestList",list);
        return nextView;
    }

    @GetMapping("/request_enroll")
    @ResponseBody
    public ModelAndView viewRequestEnrollPage() {
        ModelAndView nextView=new ModelAndView("request_enroll");
        return nextView;
    }
    @PostMapping("/request_enroll")
    @ResponseBody
    public ModelAndView viewRequestEnrollPage(Request request){
        servicempl.createRequest(request);
        ModelAndView nextView=new ModelAndView("request_detail_writer");
        List<Request> list=servicempl.findAll();
        nextView.addObject("requestList",list);
        return nextView;
    }

    @GetMapping("/request_detail_user")
    @ResponseBody
    public String viewRequestDetailUserPage() {

        return "request_detail_user";
    }

    @GetMapping("/request_detail_writer/{reqId}")
    @ResponseBody
    public ModelAndView viewRequestDetailWriterPage(@PathVariable("reqId") int reqId) {
        Request req=servicempl.findByReqId(reqId);

        ModelAndView nextView=new ModelAndView("/request_detail_writer");
        nextView.addObject("Request", req);
        return nextView;
    }
}
