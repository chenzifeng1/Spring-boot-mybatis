package com.chenzifeng.learn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.Role;
import com.chenzifeng.learn.dao.RoleDao;
import com.chenzifeng.learn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void insertRole(JSONObject jsonObject) {

        roleDao.insertRole(jsonObject);
    }

    @Override
    public List<JSONObject> listRole(JSONObject jsonObject) {

        return roleDao.listRole(jsonObject);
    }
}
