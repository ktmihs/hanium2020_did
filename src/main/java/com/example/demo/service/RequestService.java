package com.example.demo.service;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {
    List<Request> findAll();
    void createRequest(Request request);
    Request findByReqId(int reqId);
    RequestRepository getRequestRepository();
    void setRequestRepository(RequestRepository requestRepository);
}
