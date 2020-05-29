package com.chenzifeng.learn.bean;

import java.io.Serializable;
import java.util.Set;

public class Role  implements Serializable{

    private static final long serialVersionUID = -4566896702061159547L;

    private String id;
    private String roleName;

    /**
     * 角色对应的权限集合
     */
    private Set<Permissions> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }
}
