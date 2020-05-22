package com.chenzifeng.learn.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 *  传递结果信息的JSon对象
 *  code 返回结果代码:
 *  -1： 错误结果
 *  1： 成功结果
 */
public class JSONMessage {
    private String code;
    private String msg;



    public JSONObject JSONResult(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",this.code);
        jsonObject.put("msg",this.msg);
        return jsonObject;
    }



    public JSONMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JSONMessage() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
