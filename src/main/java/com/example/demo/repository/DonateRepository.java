package com.example.demo.repository;

import com.example.demo.model.Donate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonateRepository extends JpaRepository<Donate, Integer> {
    Donate findByDonateId(Integer donateId);
    //Donate findByDonateId(DonateId donateId);        //donateId로 하나 찾기
    //Donate getOne(int donateId);
}