package com.liuliu.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = "这是一个测试接口")
@ApiModel(value = "这是测试接口",description = "测试swagger接口文档")
public class TestContrller {

    @GetMapping("/api")
    // value 方法的用途和作用  notes方法的备注说明
    @ApiOperation(value = "接口方法测试",notes = "根据用户名和密码进行判断用户是否存在")
//    参数的说明 paramType参数放在什么地方 query 参数使用@RequestParam   path： 参数 使用@PathVariable注解
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username" ,value = "用户名",required = true,paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "password" ,value = "密码",required = true,paramType = "query",dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
            @ApiResponse(code=200,message="请求成功"),
            @ApiResponse(code=500,message="服务器端发生内部错误")
    })

    public String testApi( @RequestParam String username, @RequestParam String password){
        return null;
    }
}
