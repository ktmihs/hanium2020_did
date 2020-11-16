package com.example.demo.repository;

import com.example.demo.model.Group;
import com.example.demo.model.GroupDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupDetailRepository  extends JpaRepository<GroupDetail, String> {
    GroupDetail findByGcId(String groupId);
}