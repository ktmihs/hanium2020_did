package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.model.User;
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
    @Override
    public List<Donate> findByRequest(Request request){
        return Lists.newArrayList(donateRepository.findByRequest(request));

    }
    @Override
    public List<Donate> findAllByUser(User user) {
        return Lists.newArrayList(donateRepository.findAllByUser(user));
    }

    public void save(Donate donate){
        donateRepository.save(donate);
    }
    public Donate findByDonateId(Integer donateId){
        return donateRepository.findByDonateId(donateId);
    }

    @Autowired
    public DonateRepository getDonateRepository() {
        return donateRepository;
    }
    @Autowired
    public void setDonateRepository(DonateRepository donateRepository) {              //setter
        this.donateRepository = donateRepository;
    }
}

