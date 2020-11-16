package com.example.demo.controller;

import com.example.demo.model.User;

import java.io.Serializable;

public class UserSession implements Serializable {

    private User user;
    private String userId;

    public UserSession(User user) {
        this.user = user;
    }

    public UserSession(User user, String userId) {
        this.user = user;
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
