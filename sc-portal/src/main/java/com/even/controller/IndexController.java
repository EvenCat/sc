package com.even.controller;

import com.even.common.ResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 北方、
 * @title: IndexController
 * @projectName sc
 * @description: TODO
 * @date 2020/8/1 15:22
 */
@RestController
public class IndexController {

    /*@NacosValue(value = "${str}",autoRefreshed = true)
    private String str = "default";*/

    @RequestMapping("/portal")
    public ResponseModel test(HttpServletRequest request, HttpServletResponse response){
        return new ResponseModel().OK("请求成功");
    }

    @GetMapping("/user")
    public ResponseModel getUser(){
        return ResponseModel.OK("请求成功","张三");
    }
}
