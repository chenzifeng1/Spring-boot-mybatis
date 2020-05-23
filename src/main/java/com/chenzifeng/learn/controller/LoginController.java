package com.chenzifeng.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.service.LoginService;
import com.chenzifeng.learn.utils.JSONMessage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public JSONObject login(@RequestBody JSONObject jsonObject){
        logger.info(jsonObject.toString());
        return loginService.authLogin(jsonObject);
    }

    @RequiresPermissions("user:list")
    @GetMapping("/login-test")
    public JSONObject test(){
         JSONMessage jsonMessage= new JSONMessage();
         jsonMessage.setCode("100");
         jsonMessage.setMsg("success");
         return jsonMessage.JSONResult();
    }
}
