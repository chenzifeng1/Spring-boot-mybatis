package com.chenzifeng.learn.exception;

import com.alibaba.fastjson.JSONObject;
import com.chenzifeng.learn.utils.ErrorEnum;
import com.chenzifeng.learn.utils.JSONMessage;

/**
 * @program: com.chenzifeng.learn.exception
 * @author: chenzifeng
 * @description: 本项目通用的异常类，拦截器统一拦截这个异常，并将其中的JSON对象返回给前段
 * @create: 2020-05-23 13:39
 **/

public class CommonJSONException extends RuntimeException{
    private JSONObject result ;

    /**
     * 传入一个携带错误信息的枚举类，转换为Json对象
     * @param errorEnum
     */
    public CommonJSONException(ErrorEnum errorEnum) {
        this.result =new JSONMessage().JSONResult(errorEnum);
    }

    public CommonJSONException(JSONObject result) {
        this.result = result;
    }

    public JSONObject getResult() {
        return result;
    }
}
