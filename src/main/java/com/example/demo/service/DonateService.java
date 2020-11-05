package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.repository.DonateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonateService {
    List<Donate> findAll();
    void createDonate(Donate donate);
    Donate findByDonateId(int donateId);
    DonateRepository getDonateRepository();
    void setDonateRepository(DonateRepository donateRepository);
}
