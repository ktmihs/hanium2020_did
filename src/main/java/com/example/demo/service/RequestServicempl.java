package com.example.demo.service;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("RequestService")
public class RequestServicempl implements RequestService {
    RequestRepository requestRepository;

    @Override
    public List<Request> findAll(){
        List<Request> list=requestRepository.findAll();
        return list;
    }
    @Override
    public void createRequest(Request request) {
        requestRepository.save(request);
    }
    @Override
    public Request findByReqId(int reqId){
        return requestRepository.findByReqId(reqId);
    }


    @Autowired
    public RequestRepository getRequestRepository() {
        return requestRepository;
    }
    @Autowired
    public void setRequestRepository(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }



}
