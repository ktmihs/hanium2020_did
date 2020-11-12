package com.example.demo.service;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import lombok.NoArgsConstructor;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Transactional
@NoArgsConstructor
@SpringBootApplication
@Service("RequestService")
public class RequestServicempl implements RequestService {
    @Autowired
    RequestRepository requestRepository;

    @Override
    public Page<Request> findAll(Pageable pageable){
        Page<Request> lists=requestRepository.findAll(pageable);     //JPARepository의 findAll()함수 사용
//        List<Request> requestList=new ArrayList<>();

//        for(Request request:lists){
//            Request request1 = new Request(request.getReqId(),request.getReqDeadline(),request.getReqAmount(),request.getReqTitle(),request.getReqReason());
//            requestList.add(request1);
//        }
//        return Lists.newArrayList(requestRepository.findAll());
//        return requestList;
        return lists;
    }



    @Override
    public void createRequest(Request request) {
    //    String convertPw = UUID.randomUUID().toString().replace("-", "");

        requestRepository.save(request);                    //JPARepository의 save()함수 사용하여 request내용 저장
    }
    @Override
    public Request findByReqId(Integer reqId){
        return requestRepository.findByReqId(reqId);           //reqId로 하나 찾아오기
    }


    @Autowired
    public RequestRepository getRequestRepository() {
        return requestRepository;
    }   //getter
    @Autowired
    public void setRequestRepository(RequestRepository requestRepository) {         //setter
        this.requestRepository = requestRepository;
    }



}
