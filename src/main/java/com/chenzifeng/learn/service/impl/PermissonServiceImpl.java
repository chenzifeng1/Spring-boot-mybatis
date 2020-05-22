package com.chenzifeng.learn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.dao.PermissionDao;
import com.chenzifeng.learn.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissonServiceImpl implements PermissionService{

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void insertPermission(JSONObject jsonObject) {
        permissionDao.insertPermission(jsonObject);
    }
}
