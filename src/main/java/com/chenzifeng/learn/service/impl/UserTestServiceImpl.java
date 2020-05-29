package com.chenzifeng.learn.service.impl;

import com.chenzifeng.learn.bean.User;
import com.chenzifeng.learn.service.UserService;
import com.chenzifeng.learn.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;


/**
 * @program: com.chenzifeng.learn.webService
 * @author: chenzifeng
 * @description:
 * @create: 2020-05-26 16:56
 **/

@WebService(serviceName = "UserTestService",
        targetNamespace = "http://webService.learn.chenzifeng.com",
        endpointInterface = "com.chenzifeng.learn.service.UserTestService")
@Component
public class UserTestServiceImpl implements UserTestService {

    @Autowired
    private UserService userService;

    @Override
    public String userInfo(String username) {
        return "the user name is" + username;
    }

    @Override
    public User getUser(User user) {
        System.out.println(user.toString());
        return null;
    }
}
