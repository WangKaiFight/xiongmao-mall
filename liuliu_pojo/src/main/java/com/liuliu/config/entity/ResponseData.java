package com.liuliu.config.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.liuliu.config.entity.ResponseCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//API接口的响应结果的封装  相应结果都是JSON
// 表示在转换json的时候  值为空为null不参加转换
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ResponseData<T>  implements Serializable {
    //请求结果的消息描述
    private String message;
    //请求的状态码
    private int status;
    //相应数据
    private Map<String,T> data = new HashMap<>();
    // 提供属性的get方法

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, T> getData() {
        return data;
    }

    public ResponseData putDataVule(String key, T value){
        data.put(key,value);
        return  this;
    }
    public ResponseData(int status, String message){
        this.status = status;
        this.message=message;
    }

    public static<T> ResponseData<T> success(){
        return  new ResponseData(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }
    public static<T> ResponseData<T> notFound(){
        return  new ResponseData(ResponseCode.NOTFOUND.getCode(),ResponseCode.NOTFOUND.getDesc());
    }
    public static<T> ResponseData<T> badRequest(){
        return  new ResponseData(ResponseCode.REQUESTBAD.getCode(),ResponseCode.REQUESTBAD.getDesc());
    }
    public static<T> ResponseData<T> forbidden(){
        return  new ResponseData(ResponseCode.FORBIDDEN.getCode(),ResponseCode.FORBIDDEN.getDesc());
    }
    public static<T> ResponseData<T> unauthorozed(){
        return  new ResponseData(ResponseCode.UNAUTHORIZED.getCode(),ResponseCode.UNAUTHORIZED.getDesc());
    }
    public static<T> ResponseData<T> serverInternalError(){
        return  new ResponseData(ResponseCode.SERVERERROR.getCode(),ResponseCode.SERVERERROR.getDesc());
    }
    public static<T> ResponseData<T> cusstomerError(){
        return  new ResponseData(ResponseCode.CUSTOMEERROR.getCode(),ResponseCode.CUSTOMEERROR.getDesc());
    }
}
