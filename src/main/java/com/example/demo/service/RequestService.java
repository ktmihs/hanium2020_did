package com.example.demo.service;

import com.example.demo.model.Request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {
    List<Request> findAll();
}
