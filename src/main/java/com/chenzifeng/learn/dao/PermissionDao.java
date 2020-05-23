package com.chenzifeng.learn.dao;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.Permissions;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao {

    void insertPermission(JSONObject jsonObject);

    /**
     * 查询是否存在权限
     * @param jsonObject 传入的Json对象需要包含 permissionCode
     * @return 返回0 ：数据库中不存在该权限
     */
    int queryIsExistPermissonCode(JSONObject jsonObject);

    /**
     * 根据Permission名字获取Permission对象
     * @param jsonObject 传入参数要包含 permissionName
     * @return 返回Permission对象
     */
    Permissions getPermissionByCode(JSONObject jsonObject);

}
