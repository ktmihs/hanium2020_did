package com.example.demo.service;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {

    List<Request> findAll();                                            //전체목록 불러오기
    void createRequest(Request request);                                //요청 페이지 작성하기
    Request findByReqId(String reqId);                                  //reqId로 하나 불러오기
    RequestRepository getRequestRepository();                           //getter
    void setRequestRepository(RequestRepository requestRepository);     //setter

}

