package com.chenzifeng.learn.service;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.User;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;

@Repository
public interface LoginService {


     JSONObject authLogin(JSONObject jsonObject);
}
