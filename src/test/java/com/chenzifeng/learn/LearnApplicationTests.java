package com.chenzifeng.learn;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearnApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {


    }

}
