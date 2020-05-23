package com.chenzifeng.learn.service;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.Permissions;


public interface PermissionService {
    void insertPermission(JSONObject jsonObject);

    int queryIsExistPermission(JSONObject jsonObject);

    Permissions getPermissionByCode(JSONObject jsonObject);
}
