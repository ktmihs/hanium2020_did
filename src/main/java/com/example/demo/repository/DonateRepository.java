package com.example.demo.repository;

import com.example.demo.model.donate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonateRepository extends JpaRepository<donate, String> {
    public void donate_create(donate don) throws Exception;

    public donate donate_read(String req_id) throws Exception;

    public void donate_update(donate don) throws Exception;

    public void donate_delete(String req_id) throws Exception;

    public List<donate> donate_listAll() throws Exception;
}