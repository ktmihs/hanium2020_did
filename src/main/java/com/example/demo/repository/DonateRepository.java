package com.example.demo.repository;

import com.example.demo.model.Donate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonateRepository extends JpaRepository<Donate, String> {
    public void donate_create(Donate don) throws Exception;

    public Donate donate_read(String req_id) throws Exception;

    public void donate_update(Donate don) throws Exception;

    public void donate_delete(String req_id) throws Exception;

    public List<Donate> donate_listAll() throws Exception;
}