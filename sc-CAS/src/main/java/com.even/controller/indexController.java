package com.even.controller;

import com.even.common.ResponseCode;
import com.even.common.ResponseModel;
import com.even.pojo.viewModel.LoginModel;
import com.even.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 北方、
 * @title: indexController
 * @projectName sc
 * @description: TODO
 * @date 2020/8/1 21:24
 */
//@RestController
public class indexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseModel test(@RequestBody LoginModel loginModel, HttpServletRequest request, HttpServletResponse response){
        return userService.login(loginModel,request,response);
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResponseModel login(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if (name.equals("sid")){
                    return new ResponseModel().OK("验证通过");
                }
            }
        }
        return new ResponseModel(ResponseCode.REDIRECT,"未登录");

    }

    @RequestMapping("/check")
    public ResponseModel checkToken(String token, HttpServletRequest request){
        return null;
    }

    @RequestMapping("/cas")
    public ResponseModel test( HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.print("name:"+cookie.getName());
            System.out.println(" value:"+cookie.getValue());
        }
        response.addCookie(new Cookie("cas","这是cas的cookie"));
        return new ResponseModel().OK("请求成功");
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/insert")
    public void testInsert(){
        long start = System.currentTimeMillis();
        jdbcTemplate.batchUpdate("INSERT INTO user (name,password,flag) VALUES (?,?,?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1,"思瑞三");
                ps.setString(2,"123124");
                ps.setInt(3,12);
            }

            @Override
            public int getBatchSize() {
                return 10000;
            }
        });

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


}
