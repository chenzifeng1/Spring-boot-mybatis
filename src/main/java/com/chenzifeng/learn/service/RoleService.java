package com.chenzifeng.learn.service;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.Role;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RoleService {

    void insertRole(JSONObject jsonObject);

    List<JSONObject> listRole(JSONObject jsonObject);
}
