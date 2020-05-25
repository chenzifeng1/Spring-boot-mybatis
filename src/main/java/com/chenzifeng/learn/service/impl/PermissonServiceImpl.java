package com.chenzifeng.learn.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.Permissions;
import com.chenzifeng.learn.dao.PermissionDao;
import com.chenzifeng.learn.dao.RoleDao;
import com.chenzifeng.learn.exception.CommonJSONException;
import com.chenzifeng.learn.service.PermissionService;
import com.chenzifeng.learn.utils.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 优化：使用redis将权限的id和permissionCode使用set存入内存，插入的时候直接拿出来比对，不必读取数据库
 */

@Service
public class PermissonServiceImpl implements PermissionService{

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RoleDao roleDao;

    private static final Logger logger = LoggerFactory.getLogger(PermissionService.class);

    @Override
    public void insertPermission(JSONObject jsonObject) {
        int permissionCount = permissionDao.queryIsExistPermissonCode(jsonObject);
        if (permissionCount>0)
            throw new CommonJSONException(ErrorEnum.E_60001);
        else
        permissionDao.insertPermission(jsonObject);
    }

    @Override
    public int queryIsExistPermission(JSONObject jsonObject) {
        return permissionDao.queryIsExistPermissonCode(jsonObject);
    }

    @Override
    public Permissions getPermissionByCode(JSONObject jsonObject) {
        return permissionDao.getPermissionByCode(jsonObject);
    }

    @Override
    public JSONObject getUserPermissions(JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        int userId = jsonObject.getInteger("userId");
        System.out.println(username+":"+userId);
        return getUserPermissionFromDB(username,userId);
    }


    private JSONObject getUserPermissionFromDB(String username,int userId){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",username);
        jsonObject.put("userId",userId);

        //获取用户的角色id
        List<Integer> roleIds = roleDao.getIdsByUser(jsonObject);

        logger.info(roleIds.toString());


        List<Integer>  permissionIds = new ArrayList<>();

        for (int roleId:roleIds){
            JSONObject roleJson = new JSONObject();
            roleJson.put("roleId",roleId);
            for(int p :permissionDao.getIdsByRole(roleJson)){
                if(!permissionIds.contains(p))
                    permissionIds.add(p);
            }

        }

        logger.info(permissionIds.toString());

        if(permissionIds.size()>0){
            JSONObject result = new JSONObject();
            List<String> permissionCodes = permissionDao.getPermissionCodeById(permissionIds);

            logger.info(permissionCodes.toString());

            result.put("permissionId",permissionIds);
            result.put("permissionCode",permissionCodes);
            return result;
        }

        return null;
    }
}
