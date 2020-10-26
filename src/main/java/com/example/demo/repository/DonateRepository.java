package com.example.demo.repository;

import com.example.demo.model.donate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DonateRepository extends JpaRepository<donate, String> {
    public List<donate> findAll();
}