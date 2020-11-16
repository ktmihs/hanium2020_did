package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.repository.DonateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonateService {
    List<Donate> findAll();
    List<Donate> findAllByUser(User user);
    List<Donate> findByRequest(Request request);
    void save(Donate donate);
    Donate findByDonateId(Integer donateId);
    DonateRepository getDonateRepository();                             //getter
    void setDonateRepository(DonateRepository donateRepository);        //setter
}
