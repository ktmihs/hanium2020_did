package com.example.demo.repository;

import com.example.demo.model.Request;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

    Request findByReqId(Integer reqId);     //reqId로 하나 찾기
    void deleteByReqId(Integer reqId);      //reqId로 하나 지우기
    List<Request> findOneByReqId(String reqId);
    List<Request> findAllByUser(User user);
}
