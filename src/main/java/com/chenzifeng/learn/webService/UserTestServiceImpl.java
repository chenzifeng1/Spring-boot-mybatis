package com.chenzifeng.learn.webService;

import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import javax.jws.WebService;


/**
 * @program: com.chenzifeng.learn.webService
 * @author: chenzifeng
 * @description:
 * @create: 2020-05-26 16:56
 **/

@WebService(serviceName = "UserTestService",
        targetNamespace = "http://webService.learn.chenzifeng.com",
        endpointInterface = "com.chenzifeng.learn.webService.UserTestService")
@Component
public class UserTestServiceImpl implements UserTestService {
    @Override
    public String userInfo(String username) {
        return "the user name is" + username;
    }
}
