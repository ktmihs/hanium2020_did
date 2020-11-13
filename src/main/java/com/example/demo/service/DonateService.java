package com.example.demo.service;

import com.example.demo.model.BloodDonation;
import com.example.demo.model.Donate;
import com.example.demo.model.DonateId;
import com.example.demo.repository.DonateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonateService {
    void save(Donate donate);
    Donate findByDonateId(DonateId donateId);
    DonateRepository getDonateRepository();                             //getter
    void setDonateRepository(DonateRepository donateRepository);        //setter
}
