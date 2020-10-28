package com.example.demo.service;

import com.example.demo.model.request;

import java.util.List;

public interface RequestService {
    void request_create(request re);
    request request_read(String req_id);
    void request_update(request re);
    void request_delete(String req_id);
    List<request> request_listAll();
}
