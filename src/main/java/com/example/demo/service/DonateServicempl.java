package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.repository.DonateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("DonateService")
public class DonateServicempl implements DonateService {
    DonateRepository donateRepository;

    @Override
    public List<Donate> findAll(){
        List<Donate> list=donateRepository.findAll();
        return list;
    }
    @Override
    public void createDonate(Donate donate){
        donateRepository.save(donate);
    }

    @Override
    public Donate findByDonateId(int donateId){
        return donateRepository.findByDonateId(donateId);
    }

    @Autowired
    public DonateRepository getDonateRepository() {
        return donateRepository;
    }
    @Autowired
    public void setDonateRepository(DonateRepository donateRepository) {
        this.donateRepository = donateRepository;
    }
}

