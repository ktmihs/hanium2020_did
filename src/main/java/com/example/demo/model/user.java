package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="\"user\"")
@Data
public abstract class user {
    @NonNull
    private String id;
    private String user_name;
    private String user_password;
    private int user_birth;
    private int user_gender;
    private String user_phone;
    private String user_address;
    private String user_email;
    private String user_inputdate;
    private String g_id;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getUser_name(){
        return user_name;
    }

    public void setUser_name(String user_name){
        this.user_name=user_name;
    }

    public String getUser_password(){
        return user_password;
    }

    public void setUser_password(String user_password){
        this.user_password=user_password;
    }

    public int getUser_birth(){
        return user_birth;
    }

    public void setUser_birth(int user_birth){
        this.user_birth=user_birth;
    }

    public int getUser_gender(){
        return user_gender;
    }

    public void setUser_gender(int user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_inputdate() {
        return user_inputdate;
    }

    public void setUser_inputdate(String user_inputdate) {
        this.user_inputdate = user_inputdate;
    }

    public String getG_id() {
        return g_id;
    }

    public void setG_id(String g_id) {
        this.g_id = g_id;
    }
}   //



    //데이터베이스
