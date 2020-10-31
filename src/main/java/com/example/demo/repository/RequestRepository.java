package com.example.demo.repository;

import com.example.demo.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, String> {
    public void request_create(Request re) throws Exception;

    public Request request_read(String req_id) throws Exception;

    public void request_update(Request re) throws Exception;

    public void request_delete(String req_id) throws Exception;

    public List<Request> request_listAll() throws Exception;
}
