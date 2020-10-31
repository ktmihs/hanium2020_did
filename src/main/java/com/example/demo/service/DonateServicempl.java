package com.example.demo.service;

import com.example.demo.model.Donate;
import com.example.demo.repository.DonateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("DonateServiceService")
public class DonateServicempl implements DonateService {
    DonateRepository donateRepository;

    //1. 게시글 작성
    @Override
    public void donate_create(Donate don) throws Exception{
        int donate_amount=don.getDonateAmount();

        donateRepository.donate_create(don);
    }

    //2. 게시글 상세보기
    @Override
    public Donate donate_read(String req_id) throws Exception{
        return donateRepository.donate_read(req_id);
    }

    //3. 게시글 수정
    @Override
    public void donate_update(Donate don) throws Exception{
        donateRepository.donate_update(don);
    }

    //4. 게시글 삭제
    @Override
    public void donate_delete(String req_id) throws Exception{
        donateRepository.donate_delete(req_id);
    }

    //5. 게시글 전체 목록
    @Override
    public List<Donate> donate_listAll() throws Exception{
        return donateRepository.donate_listAll();
        //return Lists.newArrayList(donateRepository.donate_listAll());
    }
    @Autowired
    public DonateRepository getDonateRepository() {
        return donateRepository;
    }
    @Autowired
    public void setDonateRepository(DonateRepository donateRepository) {
        this.donateRepository = donateRepository;
    }
}
