package com.example.demo.service;

import com.example.demo.model.Group;
import com.example.demo.model.GroupDetail;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findByUserIdAndUserPassword(String userId, String password);
    User findByUserId(String userId);
    User save(User user);
    void save(Group group);
    void save(GroupDetail gd);
    GroupDetail findBygcId(String groupId);
}
