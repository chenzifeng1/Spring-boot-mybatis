package com.chenzifeng.learn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@SpringBootTest
public class TestUseCase {
    @Autowired
    UserService userService;

    @Test
    public void insetTest() {

        String username = "test";
        String password = "psw";
        String realname = "czf";

        for (int i = 0; i < 10; i++) {
            JSONObject jsonObject = new JSONObject();
            username+=i;
            password+=i;
            realname+=i;
            System.out.println(username);
            System.out.println(password);
            System.out.println(realname);
            jsonObject.put("username",username);
            jsonObject.put("password",password);
            jsonObject.put("realName",realname);
            userService.addUser(jsonObject);
        }
    }

    @Test
    public void selectTest(){
        for(int i =13 ;i<24;i++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",i);
            System.out.println(userService.getOne(jsonObject));
        }
    }

    @Test
    public void DateTest(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(new Date()).toString());
    }

    @Test
    public void JSONTest(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tankCode","1,2,3,4");
        jsonObject.put("stationCode","19561464");
        System.out.println(jsonObject.toString());
//        Map<String,String> tankMap = JSON.parseObject(jsonObject.toJSONString(),Map.class);
//        tankMap.put("tankCode","1");
//        jsonObject = JSONObject.parseObject(JSON.toJSONString(tankMap));
        jsonObject.put("stationCode","1");
        System.out.println(jsonObject.toString());

        System.out.println(jsonObject.getInteger("asd"));
        jsonObject.put("date",new Date());
        System.out.println(jsonObject.getDate("date"));
    }
}
