package com.example.demo.service;

<<<<<<< HEAD
import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.repository.DonateRepository;
import org.assertj.core.util.Lists;
=======

import com.google.common.collect.Lists;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
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
<<<<<<< HEAD
public class DonateServicempl implements DonateService {
    DonateRepository donateRepository;
=======
public class DonateServicempl implements DonateService  {
    private DonateRepository donateRepository;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16

    @Override
    public List<Donate> findAll(){
        //   List list = newArrayList(test2Repository.findAll());
        return Lists.newArrayList(donateRepository.findAll());
<<<<<<< HEAD
    }
    @Override
    public List<Donate> findByRequest(Request request){
        return Lists.newArrayList(donateRepository.findByRequest(request));

    }
    @Override
    public List<Donate> findAllByUser(User user) {
        return Lists.newArrayList(donateRepository.findAllByUser(user));
    }

    @Override
    public void bdSave(Donate donate){
        donateRepository.save(donate);
    }

    @Override
    public Donate findByDonateId(Integer donateId){
        return donateRepository.findByDonateId(donateId);
=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
    }

    @Autowired
    public DonateRepository getDonateRepository() {
        return donateRepository;
    }
    @Autowired
    public void setDonateRepository(DonateRepository donateRepository) {              //setter
        this.donateRepository = donateRepository;
    }
<<<<<<< HEAD
}

=======
}
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
