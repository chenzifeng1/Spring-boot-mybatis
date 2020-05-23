package com.chenzifeng.learn.utils.pojo;

import com.chenzifeng.learn.bean.Role;

import java.util.Set;

/**
 * @program: com.chenzifeng.learn.utils.pojo
 * @author: chenzifeng
 * @description:
 * @create: 2020-05-23 17:54
 **/

public class UserInfo {
    private int userId;
    private String username;

    private Set<Integer> roleIds;

    private Set<Integer> permissionIds;

    private Set<String> permissionCodes;


}
