package com.chenzifeng.learn.bean;

import java.io.Serializable;


public class UserBean implements Serializable {

    public UserBean() {
    }

    private int id;
    private String username;
    private String password;
    private String realName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }


    @Override
    public String toString() {
        return "the user information : \n"
                + "id :" + id + "\n"
                + "username:" + username + "\n"
                + "password:" + password + "\n"
                + "realName:" + realName;
    }
}
