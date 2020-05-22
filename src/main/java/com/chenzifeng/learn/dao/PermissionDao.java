package com.chenzifeng.learn.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao {

    void insertPermission(JSONObject jsonObject);
}
