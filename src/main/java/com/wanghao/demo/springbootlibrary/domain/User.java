package com.wanghao.demo.springbootlibrary.domain;

import lombok.Data;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPwd;

    private String userEmail;

    private String userSex;

    private String userTel;
    private Date userBoring;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Date getUserBoring() {


        return userBoring;

    }

    public void setUserBoring(Date userBoring) {


        this.userBoring = userBoring;
    }




}

