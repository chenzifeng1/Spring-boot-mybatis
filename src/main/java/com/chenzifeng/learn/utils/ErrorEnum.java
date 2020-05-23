package com.chenzifeng.learn.utils;

public enum ErrorEnum {

    /*
     * 错误信息
     * */
    E_400("400", "请求处理异常，请稍后再试"),
    E_405("405", "请求方式有误,请检查 GET/POST"),
    E_500("500","服务器处理逻辑错误"),
    E_501("501", "请求路径不存在"),
    E_502("502", "权限不足"),

    E_60001("60001","重复插入"),
    E_60002("60002","数据库没有此数据");

    private String errorCode;
    private String errorMsg;

    ErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
