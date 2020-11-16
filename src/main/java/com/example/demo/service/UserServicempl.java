package com.example.demo.service;

import com.example.demo.model.Group;
import com.example.demo.model.GroupDetail;
import com.example.demo.model.User;
import com.example.demo.repository.GroupDetailRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@NoArgsConstructor
@SpringBootApplication
@Service("UserServicempl")
public class UserServicempl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    GroupDetailRepository groupDetailRepository;


    @Override
    public User findByUserIdAndUserPassword(String userId, String password) {
        return userRepository.findByUserIdAndUserPassword(userId, password);
    }

    @Override
    public User findByUserId(String userId){
        return (userRepository.findByUserId(userId));
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public GroupDetail findBygcId(String groupId){return groupDetailRepository.findByGcId(groupId); }

    @Override
    public void save(Group group){groupRepository.save(group); }

    @Override
    public void save(GroupDetail gd){groupDetailRepository.save(gd); }
}
