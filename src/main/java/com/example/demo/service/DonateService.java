package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.repository.DonateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonateService {
    List<Donate> findAll();                                             //내 기부 목록 전체 가져오기
    void createDonate(Donate donate);                                   //기부 페이지 작성
    Donate findByDonateId(int donateId);                                //기부페이지에서 하나 가져오기
    DonateRepository getDonateRepository();                             //getter
    void setDonateRepository(DonateRepository donateRepository);        //setter
}
