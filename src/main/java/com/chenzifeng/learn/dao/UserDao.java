package com.chenzifeng.learn.dao;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 根据某一字段获取数据对象，不一定唯一
     * @param jsonObject
     * @return
     */
    List<UserBean> getUserByName(JSONObject jsonObject);

    /**
     * 添加用户
     * @param jsonObject
     * @return
     */
    void addUser(JSONObject jsonObject);


    JSONObject deleteUser(JSONObject jsonObject);

    /**
     * getOne：根据主键id获取数据对象，唯一
     * @param jsonObject
     * @return
     */
    UserBean getOne(JSONObject jsonObject);

    void updateUser(JSONObject oldOne,JSONObject newOne);



}
