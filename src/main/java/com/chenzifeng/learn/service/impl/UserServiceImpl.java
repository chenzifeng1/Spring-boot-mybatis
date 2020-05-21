package com.chenzifeng.learn.service.impl;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.UserBean;
import com.chenzifeng.learn.dao.UserDao;
import com.chenzifeng.learn.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    //@Autowired(required = false) 表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错。 建议用@Repository
    @Autowired
    UserDao userDao;

    @Override
    public List<JSONObject> getUserByUserNameLike(JSONObject jsonObject) {
        String name = jsonObject.getString("username");
        logger.info("search username:" + name);

        List<UserBean> userLists = userDao.getUserByNameLike(jsonObject);

        List<JSONObject> results = new ArrayList<>();
        for (UserBean user : userLists) {
            JSONObject object = new JSONObject();
            object.put("id", user.getId());
            object.put("username", user.getUsername());
            object.put("password", user.getPassword());
            object.put("realName", user.getRealName());
            results.add(object);
        }
        return results;
    }


    @Override
    public void addUser(JSONObject jsonObject) {
        System.out.println(jsonObject.toString());
        if (jsonObject.isEmpty()) {
            jsonObject = new JSONObject();
            try {
                jsonObject.put("username", "test");
                jsonObject.put("password", "132");
                jsonObject.put("realName", "test");
            } catch (JSONException jse) {
                jse.printStackTrace();
            }
        }
        final UserBean userBean = new UserBean();
        userBean.setPassword(jsonObject.getString("password"));
        userBean.setUsername(jsonObject.getString("username"));
        userBean.setRealName(jsonObject.getString("realName"));
        userDao.addUser(jsonObject);
    }

    @Override
    public JSONObject deleteUser(JSONObject jsonObject) {
        int isdelete = userDao.deleteUser(jsonObject);
        logger.info("the user has delete: "+(isdelete==1));
        return null;
    }

    @Override
    public JSONObject getOne(JSONObject jsonObject) {
        UserBean userBean = userDao.getOne(jsonObject);
        logger.info(userBean.toString());
        return userToJson(userBean);
    }

    @Override
    public void updateUser(JSONObject jsonObject) {

    }


    public JSONObject userToJson(UserBean userBean){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",userBean.getId());
        jsonObject.put("username",userBean.getUsername());
        jsonObject.put("password",userBean.getPassword());
        jsonObject.put("realName",userBean.getRealName());
        return jsonObject;
    }


}
