package com.example.demo.service;

import com.example.demo.model.donate;
import com.example.demo.repository.DonateRepository;
import com.example.demo.repository.MaterialTransRepository;
import lombok.Builder;
import lombok.NonNull;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;

@Transactional
@Service("DonateService")
public class DonateServicempl {
    private DonateRepository donateRepository;

    private String req_id;
    private String user_id;
    private LocalTime donate_date;
    private int donate_amount;
    private LocalTime donate_cancel;

    public donate donateForm(){
        donate form=donate.builder()
                .req_id(req_id)
                .user_id(user_id)
                .donate_date(donate_date)
                .donate_amount(donate_amount)
                .donate_cancel(donate_cancel);
        return form;
    }
    @Builder
    public DonateServicempl(String req_id, String user_id, LocalTime donate_date, int donate_amount, LocalTime donate_cancel){
        this.req_id=req_id;
        this.user_id=user_id;
        this.donate_date=donate_date;
        this.donate_amount=donate_amount;
        this.donate_cancel=donate_cancel;
    }
    public List<donate> findAll(){
        return Lists.newArrayList(donateRepository.findAll());
    }

    @Autowired
    public void setDonateRepository(DonateRepository donateRepository){
        this.donateRepository = donateRepository;
    }
}
