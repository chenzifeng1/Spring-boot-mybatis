package com.chenzifeng.learn.bean;

import java.io.Serializable;

public class Permissions implements Serializable{

    private String id;
    private String permissionCode; //权限代码
    private String permissionName; //权限种类 ：增删查改
    private String menuCode;
    private String menuName; //权限级别：用户，角色，资源管理
    private int requiredPermission;


    public Permissions() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }


    public int getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(int requiredPermission) {
        this.requiredPermission = requiredPermission;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
