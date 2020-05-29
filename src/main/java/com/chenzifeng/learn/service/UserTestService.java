package com.chenzifeng.learn.service;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "UserTestService",
targetNamespace = "http://webService.learn.chenzifeng.com")
public interface UserTestService {


    @WebMethod
    @WebResult(name = "userInfo")
    String userInfo(@WebParam(name = "username") String username);


    @WebMethod
    @WebResult(name = "userResult")
    User getUser(@WebParam(name = "user") User user);




}
