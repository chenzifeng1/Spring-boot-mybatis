package com.chenzifeng.learn.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.Role;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RoleService {

    void insertRole(JSONObject jsonObject);

    List<JSONObject> listRole(JSONObject jsonObject);

    void insertRoleByUser(JSONObject jsonObject);

    int queryIsExistRoleName(JSONObject jsonObject);

    /**
     * 批量为角色插入权限
     * @param jsonObject 参数包括roleName,
     * @return
     */
    int insertRolePermissions(JSONObject jsonObject);
}
