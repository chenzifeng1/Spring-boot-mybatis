package com.chenzifeng.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.dao.PermissionDao;
import com.chenzifeng.learn.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    private static final Logger logger = LoggerFactory.getLogger(PermissionService.class);

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/insertPermission")
    public void insertPermission(@RequestBody JSONObject jsonObject){
        logger.info(jsonObject.toString());
        permissionService.insertPermission(jsonObject);
    }




    @GetMapping("/test")
    public JSONObject test(){
        List<Integer> t= new ArrayList<>();
        t.add(1);
        t.add(4);
        t.add(5);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("permission",t);
        return jsonObject;
    }
}
