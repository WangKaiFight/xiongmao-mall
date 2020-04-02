package com.liuliu.config.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//API接口的响应结果的封装  相应结果都是JSON
// 表示在转换json的时候  值为空为null不参加转换
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class RespnseData<T>  implements Serializable {
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
    public RespnseData putDataVule(String key,T value){
        data.put(key,value);
        return  this;
    }
    public RespnseData(int status,String message){
            this.status = status;
            this.message=message;
    }
    public static<T> RespnseData<T> success(){
        return  new RespnseData(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }
    public static<T> RespnseData<T> notFound(){
        return  new RespnseData(ResponseCode.NOTFOUND.getCode(),ResponseCode.NOTFOUND.getDesc());
    }
    public static<T> RespnseData<T> badRequest(){
        return  new RespnseData(ResponseCode.REQUESTBAD.getCode(),ResponseCode.REQUESTBAD.getDesc());
    }
    public static<T> RespnseData<T> forbidden(){
        return  new RespnseData(ResponseCode.FORBIDDEN.getCode(),ResponseCode.FORBIDDEN.getDesc());
    }
    public static<T> RespnseData<T> unauthorozed(){
        return  new RespnseData(ResponseCode.UNAUTHORIZED.getCode(),ResponseCode.UNAUTHORIZED.getDesc());
    }
    public static<T> RespnseData<T> serverInternalError(){
        return  new RespnseData(ResponseCode.SERVERERROR.getCode(),ResponseCode.SERVERERROR.getDesc());
    }
    public static<T> RespnseData<T> cusstomerError(){
        return  new RespnseData(ResponseCode.CUSTOMEERROR.getCode(),ResponseCode.CUSTOMEERROR.getDesc());
    }
}
