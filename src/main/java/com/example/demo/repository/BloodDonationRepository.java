package com.example.demo.repository;

import com.example.demo.model.BloodDonation;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodDonationRepository extends JpaRepository<BloodDonation, String> {
    List<BloodDonation> findByUserAndBdCheck(User user, byte bdCheck);
    BloodDonation findByBdId(String bdId);        //bdId로 하나 찾기

}