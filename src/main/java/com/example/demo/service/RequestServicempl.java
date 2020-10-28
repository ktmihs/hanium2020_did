package com.example.demo.service;

import com.example.demo.model.request;
import com.example.demo.repository.RequestRepository;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;

@Transactional
@Service("RequestServiceService")
public class RequestServicempl implements RequestService {
    RequestRepository requestRepository;

    //1. 게시글 작성
    @Override
    public void request_create(request re){
        //String req_id=re.getReq_id();
        //LocalTime req_date=re.getReq_date();
        LocalTime req_deadline=re.getReq_deadline();
        int req_amount=re.getReq_amount();
        String req_reason=re.getReq_reason();
        String req_title=re.getReq_title();
        //String user_id=re.getUser_id();

        //공백문자 처리
        req_title=req_title.replace(" ","&nbsp;&nbsp;");
        req_reason=req_reason.replace(" ","&nbsp;&nbsp;");
        //줄바꿈 처리
        req_reason=req_reason.replace("/n","<br>");
        re.setReq_title(req_title);
        re.setReq_reason(req_reason);

        requestRepository.request_create(re);
    }

    //2. 게시글 상세보기
    @Override
    public request request_read(String req_id){
        return requestRepository.request_read(req_id);
    }

    //3. 게시글 수정
    @Override
    public void request_update(request re){
        requestRepository.request_update(re);
    }

    //4. 게시글 삭제
    @Override
    public void request_delete(String req_id){
        requestRepository.request_delete(req_id);
    }

    //5. 게시글 전체 목록
    @Override
    public List<request> request_listAll(){
        return requestRepository.request_listAll();
        //return Lists.newArrayList(requestRepository.request_listAll());
    }

}
