package com.liuliu.config.entity;
//相应的状态码
public enum ResponseCode {
    SUCCESS(200,"Success"),
    REQUESTBAD(400,"Bad Request"),
    NOTFOUND(404,"Not Found"),
    FORBIDDEN(403,"Forbidden"),
    SERVERERROR(500,"Server Internal Error"),
    UNAUTHORIZED(401,"unauthorized"),
    CUSTOMEERROR(888,"Cusstom Error");

    private final int code;
    private final String desc;
    ResponseCode(int code,String desc){
        this.code= code;
        this.desc =desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
