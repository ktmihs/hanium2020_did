package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.model.DonateId;
import com.example.demo.repository.DonateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("DonateService")
public class DonateServicempl implements DonateService {
    DonateRepository donateRepository;

    public void save(Donate donate){
        donateRepository.save(donate);
    }
    public Donate findByDonateId(DonateId donateId){
        return donateRepository.findByDonateId(donateId);
    }

    @Autowired
    public DonateRepository getDonateRepository() {
        return donateRepository;
    }       //getter
    @Autowired
    public void setDonateRepository(DonateRepository donateRepository) {              //setter
        this.donateRepository = donateRepository;
    }
}

