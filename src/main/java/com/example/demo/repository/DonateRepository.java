package com.example.demo.repository;

import com.example.demo.model.Donate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonateRepository extends JpaRepository<Donate, String> {
    Donate findByDonateId(int donateId);        //donateId로 하나 찾기
    //Donate getOne(int donateId);
}