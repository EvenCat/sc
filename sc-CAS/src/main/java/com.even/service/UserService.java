package com.even.service;

import com.even.common.ResponseModel;
import com.even.pojo.viewModel.LoginModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 北方、
 * @title: UserService
 * @projectName sc
 * @description: TODO
 * @date 2020/8/1 18:29
 */
public interface UserService {

    ResponseModel login(LoginModel userModel, HttpServletRequest request, HttpServletResponse response);

    ResponseModel checkToken(String token,  HttpServletRequest request);

    ResponseModel autoLogin(HttpServletRequest request);
}
