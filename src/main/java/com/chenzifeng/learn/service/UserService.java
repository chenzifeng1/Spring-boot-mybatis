package com.chenzifeng.learn.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    /**
     * 根据username获取User信息
     * @param jsonObject
     * @return
     */
    List<JSONObject> getUserByUserNameLike(JSONObject jsonObject);


    void addUser(JSONObject jsonObject);

    JSONObject deleteUser(JSONObject jsonObject);

    JSONObject getOne(JSONObject jsonObject);

    void updateUser(JSONObject jsonObject);

    int countUser();

    /**
     * 根据用户名获取User信息
     * @param jsonObject
     * @return
     */
    User getUserByName(JSONObject jsonObject);

    /**
     * 根据用户名判断用户是否存在
     * @param jsonObject
     * @return
     */
    int isExist(JSONObject jsonObject);

}
