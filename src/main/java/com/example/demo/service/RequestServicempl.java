package com.example.demo.service;

import com.example.demo.model.Request;
import com.example.demo.model.User;
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
        return lists;
    }



    @Override
    public void createRequest(Request request) {
        requestRepository.save(request);                    //JPARepository의 save()함수 사용하여 request내용 저장
    }
    @Override
    public Request findByReqId(Integer reqId){
        return requestRepository.findByReqId(reqId);           //reqId로 하나 찾아오기
    }
    @Override
    public void deleteOne(Integer reqId) {
        requestRepository.deleteByReqId(reqId);
    }

    @Override
    public List<Request> findOneByReqId(String reqId){
        //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(requestRepository.findOneByReqId(reqId));
    }
    @Override
    public List<Request> findAllByUser(User user) {
        return Lists.newArrayList(requestRepository.findAllByUser(user));
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
