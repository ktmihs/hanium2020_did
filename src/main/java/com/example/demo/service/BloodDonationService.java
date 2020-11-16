package com.example.demo.service;

import com.example.demo.model.BloodDonation;
import com.example.demo.model.User;
import com.example.demo.repository.BloodDonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BloodDonationService {
    List<BloodDonation> findAll();
    BloodDonation findByBdId(String bdId);
    void saveBlood(BloodDonation bloodDonation);
    List<BloodDonation> findIdAndCheck(User user, byte bdCheck);                              //id와 check로 찾기

    BloodDonationRepository getBloodDonationRepository();                                    //getter
    void setBloodDonationRepository(BloodDonationRepository bloodDonationRepository);        //setter
}
