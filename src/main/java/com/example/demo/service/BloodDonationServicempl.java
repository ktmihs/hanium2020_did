package com.example.demo.service;

import com.example.demo.model.BloodDonation;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.repository.BloodDonationRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@NoArgsConstructor
@SpringBootApplication
@Service("BloodDonationService")
public class BloodDonationServicempl implements BloodDonationService {
    @Autowired
    BloodDonationRepository bloodDonationRepository;


    @Override
    public List<BloodDonation> findIdAndCheck(User user, byte bdCheck){
        List<BloodDonation> lists=bloodDonationRepository.findByUserAndBdCheck(user,bdCheck);
        return lists;
    }

    @Override
    public BloodDonation findByBdId(String bdId){
        return bloodDonationRepository.findByBdId(bdId);           //reqId로 하나 찾아오기
    }

    @Override
    public void saveBlood(BloodDonation bloodDonation) {
        bloodDonationRepository.save(bloodDonation);                    //JPARepository의 save()함수 사용하여 request내용 저장
    }

    @Override
    public List<BloodDonation> findAll(){
        List<BloodDonation> lists=bloodDonationRepository.findAll();
        return lists;
    }

    @Override
    public BloodDonationRepository getBloodDonationRepository() {
        return bloodDonationRepository;
    }

    @Override
    public void setBloodDonationRepository(BloodDonationRepository bloodDonationRepository) {
        this.bloodDonationRepository = bloodDonationRepository;
    }
}

