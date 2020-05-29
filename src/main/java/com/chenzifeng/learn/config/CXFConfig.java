package com.chenzifeng.learn.config;

import com.chenzifeng.learn.service.UserTestService;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @program: com.chenzifeng.learn.config
 * @author: chenzifeng
 * @description:
 * @create: 2020-05-26 16:48
 **/

@Configuration
public class CXFConfig {

    private static final Logger logger = LoggerFactory.getLogger(CXFConfig.class);

    @Autowired
    private Bus bus;

    @Autowired
    private UserTestService userTestService;

    @Bean
    public Endpoint endpoint() {
        Endpoint endpoint = new EndpointImpl(bus, userTestService);
        endpoint.publish("/UserTestService");
        return endpoint;
    }


}
