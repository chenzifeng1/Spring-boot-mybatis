package com.chenzifeng.learn.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Set;

//@XmlRootElement(name="user")
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder= {"id","username","password"})
public class User implements Serializable {

    private static final long serialVersionUID = 1336312725016506951L;

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

    /**
     *  加密所需的密码盐
     */
    private String salt;

    /**
     * 一个用户可能具有多个角色：每个角色有不同的权限
     */
    private Set<Role> roles;

    private Set<Permissions> permissions;


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

    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return
                 "{ id :" + id + ","
                + "username:" + username + ","
                + "password:" + password
                + "}";
    }
}
