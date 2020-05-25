package com.chenzifeng.learn.service;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.Permissions;

import java.util.List;


public interface PermissionService {
    void insertPermission(JSONObject jsonObject);

    int queryIsExistPermission(JSONObject jsonObject);

    Permissions getPermissionByCode(JSONObject jsonObject);

    /**
     * 通过用户名username及userId去获取user的权限
     * @param jsonObject
     * @return
     */
    JSONObject getUserPermissions(JSONObject jsonObject);
}
