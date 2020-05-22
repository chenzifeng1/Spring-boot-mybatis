package com.chenzifeng.learn.config;

import com.chenzifeng.learn.shiro.CustomRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {


    /**
     * 配置Shiro的Web过滤器，拦截浏览器请求，并交给SecurityManager处理
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean webFilter() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // Shiro配置类的过滤器中启用安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager());

        // 配置拦截链 使用LinkedHashMap，因为LinkedHashMap是有序的，Shiro会根据连接顺序进行拦截
        // Map<K,V> K是指拦截的url，V的值是该url是否被拦截
        Map<String, String> filterChainMap = new LinkedHashMap<>(16);

        //authc:所有url都必须经过认证才能访问：anon：所有url可以进行匿名访问，，先配置anon在配置authc
        filterChainMap.put("/login","anon");
        filterChainMap.put("/**","authc");

        //设置拦截请求后跳转的URL
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 安全管理器：绑定所有的Subject，负责所有与安全有关的操作
     * @return
     */
    @Bean(name = "mySecurityManager")
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //将自定义的Realm交给SecurityManager管理
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();

    }



}
