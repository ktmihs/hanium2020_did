package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.repository.DonateRepository;
import org.springframework.stereotype.Service;

@Service
public interface DonateService {
    void save(Donate donate);
    Donate findByDonateId(Integer donateId);
    DonateRepository getDonateRepository();                             //getter
    void setDonateRepository(DonateRepository donateRepository);        //setter
}
