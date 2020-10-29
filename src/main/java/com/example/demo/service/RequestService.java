package com.example.demo.service;

import com.example.demo.model.request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {
    void request_create(request re) throws Exception;
    request request_read(String req_id) throws Exception;
    void request_update(request re) throws Exception;
    void request_delete(String req_id) throws Exception;
    List<request> request_listAll() throws Exception;
}
