package com.chenzifeng.learn.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.utils.ErrorEnum;
import com.chenzifeng.learn.utils.JSONMessage;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: com.chenzifeng.learn.exception
 * @author: chenzifeng
 * @description: 统一拦截异常类，向前端返回JSON对象
 * @create: 2020-05-23 14:02
 **/


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    //为什么此处的logger要设置为对象级别的 ！！！！ 猜测：应该是因为需要在不同类中抛出异常，日志打印的应该是抛出异常的类，而不是该异常类
    private  Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    /**
     * 处理Get/Post请求种类的异常
     * 由于该异常经常在开发时出现，且该异常不在Controller内部发生，故定义该异常拦截器
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JSONObject httpRequestMethodExceptionHandler(){
        return new JSONMessage().JSONResult(ErrorEnum.E_405);
    }

    /**
     * 捕获一个CommonJSONException，返回JSON对象
     * @param cje
     * @return
     */
    @ExceptionHandler(CommonJSONException.class)
    public JSONObject commonJSONExceptionHandler(CommonJSONException cje){
        return cje.getResult();
    }


    /**
     * 捕获权限不足异常，用户权限不足以访问某一接口时，shiro会抛出该异常，捕获该异常
     * @param ue
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public JSONObject unauthorizedExceptionHandler(UnauthorizedException ue){
        return new JSONMessage().JSONResult(ErrorEnum.E_502);
    }


}
