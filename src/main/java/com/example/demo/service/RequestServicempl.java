package com.example.demo.service;

import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;

@Transactional
@Service("RequestServiceService")
public class RequestServicempl implements RequestService {
    RequestRepository requestRepository;

    //1. 게시글 작성
    @Override
    public void request_create(Request re) throws Exception{
        //String req_id=re.getReq_id();
        //LocalTime req_date=re.getReq_date();
        LocalTime req_deadline=re.getReqDeadline();
        int req_amount=re.getReqAmount();
        String req_reason=re.getReqReason();
        String req_title=re.getReqTitle();
        //String user_id=re.getUser_id();

        //공백문자 처리
        req_title=req_title.replace(" ","&nbsp;&nbsp;");
        req_reason=req_reason.replace(" ","&nbsp;&nbsp;");
        //줄바꿈 처리
        req_reason=req_reason.replace("/n","<br>");
        re.setReqTitle(req_title);
        re.setReqReason(req_reason);

        requestRepository.request_create(re);
    }

    //2. 게시글 상세보기
    @Override
    public Request request_read(String req_id) throws Exception{
        return requestRepository.request_read(req_id);
    }

    //3. 게시글 수정
    @Override
    public void request_update(Request re) throws Exception{
        requestRepository.request_update(re);
    }

    //4. 게시글 삭제
    @Override
    public void request_delete(String req_id) throws Exception{
        requestRepository.request_delete(req_id);
    }
    @Autowired
    public RequestRepository getRequestRepository() {
        return requestRepository;
    }
    @Autowired
    public void setRequestRepository(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    //5. 게시글 전체 목록
    @Override
    public List<Request> request_listAll() throws Exception{
        return requestRepository.request_listAll();
        //return Lists.newArrayList(requestRepository.request_listAll());
    }

}
