package com.example.demo.repository;

import com.example.demo.model.Donate;
import com.example.demo.model.DonateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonateRepository extends JpaRepository<Donate, DonateId> {
    Donate findByDonateId(DonateId donateId);
    //Donate findByDonateId(DonateId donateId);        //donateId로 하나 찾기
    //Donate getOne(int donateId);
}