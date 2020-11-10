package com.example.demo.service;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@NoArgsConstructor
@SpringBootApplication
@Service("RequestService")
public class RequestServicempl implements RequestService {
    RequestRepository requestRepository;

    @Override
    public List<Request> findAll(){
        List<Request> list=requestRepository.findAll();     //JPARepository의 findAll()함수 사용
        return list;
    }
    @Override
    public void createRequest(Request request) {
        requestRepository.save(request);                    //JPARepository의 save()함수 사용하여 request내용 저장
    }
    @Override
    public Request findByReqId(String reqId){
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
