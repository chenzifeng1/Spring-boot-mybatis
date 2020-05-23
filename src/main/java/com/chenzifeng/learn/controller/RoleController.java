package com.chenzifeng.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/insertRole")
    public void insertRole(@RequestBody JSONObject jsonObject){
        roleService.insertRole(jsonObject);
    }


    @GetMapping("/listRole")
    public List<JSONObject> listRole(JSONObject jsonObject){
        return roleService.listRole(jsonObject);
    }

    @PostMapping("/insertUserRole")
    public void insertUserRole(@RequestBody JSONObject jsonObject){
        roleService.insertRoleByUser(jsonObject);
    }

    /**
     * @param jsonObject 传入参数中包括一个roleName,permission
     * @return
     */
    @PostMapping("/insertRolePermissions")
    public int insertRolePermissions(@RequestBody JSONObject jsonObject){
        return roleService.insertRolePermissions(jsonObject);
    }
}
