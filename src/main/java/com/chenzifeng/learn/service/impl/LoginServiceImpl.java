package com.chenzifeng.learn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.bean.User;
import com.chenzifeng.learn.dao.UserDao;
import com.chenzifeng.learn.service.LoginService;
import com.chenzifeng.learn.utils.JSONMessage;
import org.apache.ibatis.jdbc.Null;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {


    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    /**
     * 从数据库或缓存获取Username
     *
     * @param getMapByName
     * @return
     */

    @Autowired
    private UserDao userDao;


    public User getUserByName(String getMapByName) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", getMapByName);
        int isExist = userDao.isExist(jsonObject);
        return null;
    }

    @Override
    public JSONObject authLogin(JSONObject jsonObject) {

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        logger.info(token.toString());
        //当前登录用户的信息
        Subject currentUser = SecurityUtils.getSubject();

        //去数据库查询是否有该用户：仅限用户名存在即可
        int userCount = userDao.isExist(jsonObject);
        logger.info("userCount: "+userCount);
        //如果用户名存在，那么我们尝试以登录信息进行登录验证
        if (userCount > 0) {
            try{
                currentUser.login(token);
                //如果不抛出认证异常，则为登录成果
                //实际的判断逻辑在SecurityManager中实行
                return new JSONMessage("1","成功").JSONResult();
            }catch (AuthenticationException ae){
                // 认证失败
                logger.info(ae.getMessage());
                return new JSONMessage("-1","登陆失败").JSONResult();
            }catch (NullPointerException npe){
                logger.info(npe.getMessage());
            }

        }
        //如果用户名不存在则返回用户不存在
        return new JSONMessage("-1","用户不存在").JSONResult();
    }
}
