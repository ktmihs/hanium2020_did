package com.example.demo.controller;

public class CurrentLogin {
    private String userId;
    private String password;

    public CurrentLogin() {}

    public CurrentLogin(String userId, String password) {       //현재 입력받은 정보
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
