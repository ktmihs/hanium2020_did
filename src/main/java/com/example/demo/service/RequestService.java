package com.example.demo.service;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {

    Page<Request> findAll(Pageable pageable);                           //전체목록 불러오기
    void createRequest(Request request);                                //요청 페이지 작성하기
    Request findByReqId(Integer reqId);                                 //reqId로 하나 불러오기
    void deleteOne(Integer reqId);                                      //reqId로 하나 지우기
    RequestRepository getRequestRepository();                           //getter
    void setRequestRepository(RequestRepository requestRepository);     //setter

}

