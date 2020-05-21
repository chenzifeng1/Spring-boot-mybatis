package com.chenzifeng.learn.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public String login(String username, String password, Model model){

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject currentUser = SecurityUtils.getSubject();

        try{
            //
            currentUser.login(token);
        }catch (IncorrectCredentialsException ice){
            model.addAttribute("msg","密码不正确");
        }catch (UnknownAccountException uae){
            model.addAttribute("msg","账号不存在");
        }catch (AuthenticationException ae){
            model.addAttribute("msg","状态不正常");
        }

        if (currentUser.isAuthenticated()){
            logger.info("认证成功");
            model.addAttribute("currentUser",currentUser);
            return "success";
        }else {
            token.clear();
            return "login";
        }


    }
}
