package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserIdAndUserPassword(String userId, String password);
    User findByUserId(String userName);
    User save(User user);
}
