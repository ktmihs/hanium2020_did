package com.example.demo.service;

import com.example.demo.model.donate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonateService {
    void donate_create(donate don);
    donate donate_read(String req_id);
    void donate_update(donate don);
    void donate_delete(String req_id);
    List<donate> donate_listAll();
}
