package com.chenzifeng.learn.bean;

import java.io.Serializable;
import java.util.Set;


public class User implements Serializable {

    public User() {
    }

    private int id;
    private String username;
    private String password;
    private String realName;

    /**
     * 用户状态信息：
     * 1  ：正常
     * -1 ：冻结
     * 0  ：创建未认证（比如没有激活，或者为输入验证码）
     */
    private byte status;

    private String salt; //加密所需的密码盐

    /**
     * 一个用户可能具有多个角色：每个角色有不同的权限
     */
    private Set<Role> roles;


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


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
