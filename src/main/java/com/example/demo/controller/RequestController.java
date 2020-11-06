package com.example.demo.controller;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/request_list")
    @ResponseBody
    public ModelAndView viewRequestListPage() {
        List<Request> list=servicempl.findAll();
        ModelAndView nextView=new ModelAndView("request_list");
        nextView.addObject("requestList",list);
        return nextView;
    }

    @RequestMapping("/request_enroll")
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

    @RequestMapping("/request_detail_user")
    @ResponseBody
    public String viewRequestDetailUserPage() {

        return "request_detail_user";
    }

    @RequestMapping("/request_detail_writer/{reqId}")
    @ResponseBody
    public ModelAndView viewRequestDetailWriterPage(@PathVariable("reqId") String reqId) {
        Request req=servicempl.findByReqId(reqId);


        ModelAndView nextView=new ModelAndView("/request_detail_writer");
        nextView.addObject("Request", req);
        return nextView;
    }

}
