package com.example.demo.service;

import com.example.demo.model.BloodDonation;
import com.example.demo.model.User;
import com.example.demo.repository.BloodDonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BloodDonationService {
    List<BloodDonation> findAll();
    List<BloodDonation> findByBdDoneAndBDC(String bdDonate,int bdCheck);
    BloodDonation findByBdId(String bdId);
    BloodDonation findByBdCheck(int bdCheck);
    void saveBlood(BloodDonation bloodDonation);
    List<BloodDonation> findIdAndCheck(User user, int bdCheck);                              //id와 check로 찾기

    BloodDonationRepository getBloodDonationRepository();                                    //getter
    void setBloodDonationRepository(BloodDonationRepository bloodDonationRepository);        //setter
}
