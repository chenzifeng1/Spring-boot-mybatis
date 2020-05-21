package com.chenzifeng.learn.bean;

import java.io.Serializable;

public class Permissions implements Serializable{

    private String id;
    private String permission;
    private String permissionCode; //权限代码
    private String permissionName; //权限名称
    private String menuCode; //
    private String menuName; //
    private int requiredPermission;
    private int staus;

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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
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

    public int getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(int requiredPermission) {
        this.requiredPermission = requiredPermission;
    }

    public int getStaus() {
        return staus;
    }

    public void setStaus(int staus) {
        this.staus = staus;
    }
}
