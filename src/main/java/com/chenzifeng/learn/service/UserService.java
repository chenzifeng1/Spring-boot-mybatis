package com.chenzifeng.learn.service;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    /**
     * 根据username获取User信息
     * @param jsonObject
     * @return
     */
    List<JSONObject> getUserByUserName(JSONObject jsonObject);


    void addUser(JSONObject jsonObject);

    JSONObject deleteUser(JSONObject jsonObject);

    JSONObject getOne(JSONObject jsonObject);

    void updateUser(JSONObject jsonObject);


}
