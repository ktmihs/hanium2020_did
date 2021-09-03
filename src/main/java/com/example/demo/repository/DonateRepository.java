package com.example.demo.repository;

import com.example.demo.model.Donate;
<<<<<<< HEAD
import com.example.demo.model.Request;
import com.example.demo.model.User;
=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
<<<<<<< HEAD
public interface DonateRepository extends JpaRepository<Donate, Integer> {
    Donate findByDonateId(Integer donateId);
    List<Donate> findAll();
    List<Donate> findAllByUser(User user);
    List<Donate> findByRequest(Request request);
    //Donate findByDonateId(DonateId donateId);        //donateId로 하나 찾기
    //Donate getOne(int donateId);
=======
public interface DonateRepository extends JpaRepository<Donate, String> {
    public List<Donate> findAll();
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
}