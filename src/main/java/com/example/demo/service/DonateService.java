package com.example.demo.service;

import com.example.demo.model.donate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonateService {
    void donate_create(donate don) throws Exception;
    donate donate_read(String req_id) throws Exception;
    void donate_update(donate don) throws Exception;
    void donate_delete(String req_id) throws Exception;
    List<donate> donate_listAll() throws Exception;
}
