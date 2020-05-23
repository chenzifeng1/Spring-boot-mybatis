package com.chenzifeng.learn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.Permissions;
import com.chenzifeng.learn.dao.PermissionDao;
import com.chenzifeng.learn.exception.CommonJSONException;
import com.chenzifeng.learn.service.PermissionService;
import com.chenzifeng.learn.utils.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 优化：使用redis将权限的id和permissionCode使用set存入内存，插入的时候直接拿出来比对，不必读取数据库
 */

@Service
public class PermissonServiceImpl implements PermissionService{

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void insertPermission(JSONObject jsonObject) {
        int permissionCount = permissionDao.queryIsExistPermissonCode(jsonObject);
        if (permissionCount>0)
            throw new CommonJSONException(ErrorEnum.E_60001);
        else
        permissionDao.insertPermission(jsonObject);
    }

    @Override
    public int queryIsExistPermission(JSONObject jsonObject) {
        return permissionDao.queryIsExistPermissonCode(jsonObject);
    }

    @Override
    public Permissions getPermissionByCode(JSONObject jsonObject) {
        return permissionDao.getPermissionByCode(jsonObject);
    }

}
