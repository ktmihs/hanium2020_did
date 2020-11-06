package com.example.demo.service;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import com.example.demo.model.Donate;
import com.example.demo.repository.DonateRepository;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("DonateService")
public class DonateServicempl implements DonateService  {
    private DonateRepository donateRepository;

    @Override
    public List<Donate> findAll(){
        //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(donateRepository.findAll());
    }

    @Autowired
    public void setDonateRepository(DonateRepository donateRepository){
        this.donateRepository = donateRepository;
    }
}