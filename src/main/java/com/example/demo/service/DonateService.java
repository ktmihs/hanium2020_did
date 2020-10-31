package com.example.demo.service;

import com.example.demo.model.Donate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonateService {
    void donate_create(Donate don) throws Exception;
    Donate donate_read(String req_id) throws Exception;
    void donate_update(Donate don) throws Exception;
    void donate_delete(String req_id) throws Exception;
    List<Donate> donate_listAll() throws Exception;
}
