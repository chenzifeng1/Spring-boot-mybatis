package com.chenzifeng.learn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.Role;
import com.chenzifeng.learn.bean.User;
import com.chenzifeng.learn.dao.RoleDao;
import com.chenzifeng.learn.dao.UserDao;
import com.chenzifeng.learn.exception.CommonJSONException;
import com.chenzifeng.learn.service.RoleService;
import com.chenzifeng.learn.utils.ErrorEnum;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void insertRole(JSONObject jsonObject) {
        List<Integer> permissions = (List<Integer>) jsonObject.get("permission");
        int roleCount = roleDao.queryExistRolename(jsonObject);
        //角色已存在
        if (roleCount > 0)
            throw new CommonJSONException(ErrorEnum.E_60001);
        else {
            Role role = roleDao.getRoleByName(jsonObject);
            roleDao.insertRole(jsonObject);

            //如果传来的参数中存在权限信息，则为新角色添加权限信息
            if (permissions.size() > 0) {
                roleDao.insertRolePermission(role.getId().toString(),permissions);
            }
        }

    }

    @Override
    public List<JSONObject> listRole(JSONObject jsonObject) {

        return roleDao.listRole(jsonObject);
    }

    /**
     * @param jsonObject 传递的JSON对象应包括两个字段：username,roleName
     */
    @Override
    public void insertRoleByUser(JSONObject jsonObject) {
        String username = jsonObject.getString("username");

        int userIsExist = userDao.isExist(jsonObject);
        int roleIsExist = roleDao.queryExistRolename(jsonObject);
        //user和role都存在
        if (userIsExist > 0 && roleIsExist > 0) {
            JSONObject result = new JSONObject();
            result.put("userId", userDao.getUserByName(jsonObject).getId());
            result.put("roleId", roleDao.getRoleByName(jsonObject).getId());
            roleDao.insertRoleByUser(result);
        } else if (userIsExist == 0) {
            //如果
            throw new IllegalArgumentException("插入失败，用户名不存在");
        } else {
            throw new IllegalArgumentException("插入失败，角色名不存在");
        }


    }

    @Override
    public int queryIsExistRoleName(JSONObject jsonObject) {
        return roleDao.queryExistRolename(jsonObject);
    }

    @Override
    public int insertRolePermissions(JSONObject jsonObject) {

        List<Integer> permission = (List<Integer>) jsonObject.get("permission");
        String roleName = jsonObject.getString("roleName");
        System.out.println(roleName);
        Role role =roleDao.getRoleByName(jsonObject);

        roleDao.insertRolePermission(role.getId().toString(),permission);
        return permission.size();

    }


    private void saveNewPerssion(String roleId, Collection<Integer> oldPerssion, Collection<Integer> newPerssion) {
        List<Integer> newP = new ArrayList<>();
        for (int i : newPerssion) {
            //选出老权限中没有的新权限
            if (!oldPerssion.contains(i)) {
                newP.add(i);
            }
        }
        roleDao.insertRolePermission(roleId, newP);
    }
}
