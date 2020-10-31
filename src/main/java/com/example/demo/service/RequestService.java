package com.example.demo.service;

import com.example.demo.model.Request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {
    void request_create(Request re) throws Exception;
    Request request_read(String req_id) throws Exception;
    void request_update(Request re) throws Exception;
    void request_delete(String req_id) throws Exception;
    List<Request> request_listAll() throws Exception;
}
