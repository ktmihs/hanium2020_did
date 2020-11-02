package com.example.demo.service;

import com.example.demo.model.Donate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonateService {
    List<Donate> findAll();
}
