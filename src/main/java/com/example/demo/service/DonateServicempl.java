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
        List<Donate> list=donateRepository.findAll();       //JPARepository의 findAll()함수 사용
        return list;
    }
    @Override
    public void createDonate(Donate donate){
        donateRepository.save(donate);                      //JPARepository의 save()함수 사용하여 donate 내용 저장
    }

    @Override
    public Donate findByDonateId(int donateId){
        return donateRepository.findByDonateId(donateId);   //reqId로 하나 찾아오기
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

