package com.chenzifeng.learn.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "UserTestService",
targetNamespace = "http://webService.learn.chenzifeng.com")
public interface UserTestService {


    @WebMethod
    @WebResult(name = "userInfo")
    public String userInfo(@WebParam(name = "username") String username);


}
