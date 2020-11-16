package com.example.demo.controller;

import javax.persistence.Column;

public class AccountForm {
    private String userId;
    private String name;
    private String password;
    private String checkPassword;
    private int birth;
    private int gender;
    private String phone;
    private String address;
    private String email;
    private String group;

    public AccountForm() {}

    public AccountForm(String userId, String name, String password, int birth, int gender, String phone, String address, String email) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.birth = birth;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public AccountForm(String userId, String name, String password, String checkPassword, int birth, int gender, String phone, String address, String email) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.checkPassword = checkPassword;
        this.birth = birth;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public AccountForm(String userId, String name, String password, String checkPassword, int birth, int gender, String phone, String address, String email, String group) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.checkPassword = checkPassword;
        this.birth = birth;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}