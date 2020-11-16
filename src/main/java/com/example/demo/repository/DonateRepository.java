package com.example.demo.repository;

import com.example.demo.model.Donate;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonateRepository extends JpaRepository<Donate, Integer> {
    Donate findByDonateId(Integer donateId);
    List<Donate> findAll();
    List<Donate> findAllByUser(User user);
    List<Donate> findByRequest(Request request);
    //Donate findByDonateId(DonateId donateId);        //donateId로 하나 찾기
    //Donate getOne(int donateId);
}