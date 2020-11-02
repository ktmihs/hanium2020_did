package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;

@Transactional
@Service("RequestService")
public class RequestServicempl implements RequestService {
    RequestRepository requestRepository;

    @Override
    public List<Request> findAll(){
        //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(requestRepository.findAll());
    }
    public void createBoard(Request re) {
    //    RequestRepository.save(re);
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
