package com.example.demo.service;

import com.example.demo.model.donate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonateService {
    List<donate> findAll();
}
