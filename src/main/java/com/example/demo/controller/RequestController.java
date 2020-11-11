package com.example.demo.controller;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import com.example.demo.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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
    //public RequestController(RequestService servicempl) {
    //    this.servicempl = servicempl;
    //}

    /*
    @GetMapping("/request_list")                    //전체 요청내역 페이지
    @ResponseBody
    public ModelAndView viewRequestListPage() {
        List<Request> list=servicempl.findAll();
        ModelAndView nextView=new ModelAndView("request_list");
        nextView.addObject("requestList",list);
        return nextView;
    }

    @RequestMapping("/request_list")
    public String ListDonate(Model uiModel) {
        List<Request> list = requestRepo.findAll();
        System.out.println(list);
        uiModel.addAttribute("requestList", list);
        System.out.println(list);
        return "request_list";
    }

    @RequestMapping("/request_list")
    public ModelAndView boardList(){
        List<Request> list=servicempl.findAll();
        ModelAndView nextView=new ModelAndView("request_list");
        nextView.addObject("boardList",list);
        return nextView;
    }

     */

    @RequestMapping(value = "/request_list")
    public String list(Model uiModel,@PageableDefault(sort={"reqId"},direction = Sort.Direction.DESC,size=6) Pageable pageable){
        Page<Request> requestList=servicempl.findAll(pageable);
        uiModel.addAttribute("List",requestList);
        System.out.println(requestList);
        return "request_list";
    }
    /*
    @RequestMapping(value = "/request_list")
    public String list(Model uiModel){
        List<Request> requestList=servicempl.findAll();
        uiModel.addAttribute("List",requestList);
        System.out.println(requestList);
        return "request_list";
    }
     */


    @GetMapping("/request_enroll")                  //헌혈증 요청 작성 페이지 가져오기
    @ResponseBody
    public ModelAndView viewRequestEnrollPage() {
        ModelAndView nextView=new ModelAndView("request_enroll");
        return nextView;
    }

    @PostMapping("/request_enroll")                 //헌혈증 요청 작성 페이지 저장하기 complete!!
    @ResponseBody
    public ModelAndView viewRequestEnrollPage(Request request){
        servicempl.createRequest(request);
        ModelAndView nextView=new ModelAndView("request_detail_writer");
        List<Request> list= (List<Request>) servicempl.findByReqId(request.getReqId());
        nextView.addObject("requestList",list);
        return nextView;
    }

    @RequestMapping("/request_detail_writer/{reqId}")
    @ResponseBody
    public ModelAndView viewRequestDetailWriterPage(@PathVariable("reqId") Integer reqId){
        servicempl.findByReqId(reqId);
        ModelAndView nextView=new ModelAndView("request_detail_writer");
        //List<Request> list= (List<Request>) servicempl.findByReqId(reqId);
        nextView.addObject("writerList",reqId);
        return nextView;
    }

    @RequestMapping("/request_detail_user")             //요청 작성 페이지 완료 후 보이는 페이지
    public String viewRequestDetailUserPage() {

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
