package com.example.demo.service;

import com.example.demo.model.Donate;
<<<<<<< HEAD
import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.repository.DonateRepository;
=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonateService {
    List<Donate> findAll();
<<<<<<< HEAD
    List<Donate> findAllByUser(User user);
    List<Donate> findByRequest(Request request);
    void bdSave(Donate donate);
    Donate findByDonateId(Integer donateId);
    DonateRepository getDonateRepository();                             //getter
    void setDonateRepository(DonateRepository donateRepository);        //setter
=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
}
