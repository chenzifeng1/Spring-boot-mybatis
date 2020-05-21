package com.chenzifeng.learn.dao;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 统计用户数量
     * @return
     */
    int countUser();

    /**
     * 添加用户
     * @param jsonObject
     * @return
     */
    void addUser(JSONObject jsonObject);

    User getUserByUsername(JSONObject jsonObject);


    int deleteUser(JSONObject jsonObject);

    /**
     * getOne：根据主键id获取数据对象，唯一
     * @param jsonObject
     * @return
     */
    User getOne(JSONObject jsonObject);


    void updateUser(JSONObject oldOne,JSONObject newOne);

//    进阶：返回结果为list以及多请求参数的情况


    /**
     * 根据某一字段获取数据对象，不一定唯一
     * @param jsonObject
     * @return
     */
    List<User> listUser(JSONObject jsonObject);



}
