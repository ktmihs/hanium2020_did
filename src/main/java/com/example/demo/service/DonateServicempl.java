package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.repository.DonateRepository;
import org.assertj.core.util.Lists;
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
        //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(donateRepository.findAll());
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

