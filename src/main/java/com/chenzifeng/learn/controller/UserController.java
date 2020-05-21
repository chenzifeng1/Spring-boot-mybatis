package com.chenzifeng.learn.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.service.UserService;
import com.chenzifeng.learn.service.impl.UserServiceImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @GetMapping("/countUser")
    public int countUser(){
        return userService.countUser();
    }

    @GetMapping("/getUser")
    public JSONObject getUser(@RequestBody JSONObject jsonObject) {
        logger.info(jsonObject.toString());
        return userService.getOne(jsonObject);
    }


    @PostMapping("/addUser")
    public void addUser(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject.toString());
        userService.addUser(jsonObject);
    }

    @GetMapping("/getUserByName")
    public List<JSONObject> getUserByName(@RequestBody JSONObject jsonObject){
        logger.info(jsonObject.toString());
        return userService.getUserByUserNameLike(jsonObject);
    }

    @PostMapping("/deleteUser")
    public JSONObject deleteUser(@RequestBody JSONObject jsonObject){
        return userService.deleteUser(jsonObject);
    }




}
