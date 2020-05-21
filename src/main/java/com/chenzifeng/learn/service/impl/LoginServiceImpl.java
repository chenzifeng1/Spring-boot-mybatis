package com.chenzifeng.learn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.User;
import com.chenzifeng.learn.dao.UserDao;
import com.chenzifeng.learn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    /**
     * 从数据库或缓存获取Username
     * @param getMapByName
     * @return
     */

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByName(String getMapByName) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",getMapByName);
        return userDao.getUserByUsername(jsonObject);
    }
}
