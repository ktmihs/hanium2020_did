package com.example.demo.repository;

import com.example.demo.model.BloodDonation;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodDonationRepository extends JpaRepository<BloodDonation, String> {
    List<BloodDonation> findByUserAndBdCheck(User user, int bdCheck);
    List<BloodDonation> findByBdDonateAndBdCheck(String bdDonate, int bdCheck);
    BloodDonation findByBdId(String bdId);        //bdId로 찾기
    BloodDonation findByBdCheck(int bdCheck);
}