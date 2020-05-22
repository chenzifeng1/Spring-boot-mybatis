package com.chenzifeng.learn.service.impl;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.User;
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

        List<User> userLists = userDao.listUser(jsonObject);

        List<JSONObject> results = new ArrayList<>();
        for (User user : userLists) {
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
        final User user = new User();
        user.setPassword(jsonObject.getString("password"));
        user.setUsername(jsonObject.getString("username"));
        user.setRealName(jsonObject.getString("realName"));
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
        User user = userDao.getOne(jsonObject);
        logger.info(user.toString());
        return userToJson(user);
    }

    @Override
    public void updateUser(JSONObject jsonObject) {

    }

    @Override
    public int countUser() {
        return userDao.countUser();
    }

    @Override
    public User getUserByName(JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        logger.info(username);
        final User user =userDao.getUserByName(jsonObject);
        logger.info(user.toString());
        return user;
    }

    @Override
    public int isExist(JSONObject jsonObject) {
        return userDao.isExist(jsonObject);
    }


    public JSONObject userToJson(User user){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", user.getId());
        jsonObject.put("username", user.getUsername());
        jsonObject.put("password", user.getPassword());
        jsonObject.put("realName", user.getRealName());
        return jsonObject;
    }


}
