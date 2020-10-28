package com.example.demo.repository;

import com.example.demo.model.request;

import java.util.List;

public interface RequestRepository {
    public void request_create(request re);

    public request request_read(String req_id);

    public void request_update(request re);

    public void request_delete(String req_id);

    public List<request> request_listAll();
}
