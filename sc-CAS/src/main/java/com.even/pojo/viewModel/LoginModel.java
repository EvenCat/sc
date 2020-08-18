package com.even.pojo.viewModel;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 北方、
 * @title: LoginModel
 * @projectName sc
 * @description: TODO
 * @date 2020/8/1 18:36
 */
@Data
public class LoginModel {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
//    @Length(max = 16,min = 8,message = "密码长度在8-16位之间")
    private String password;

//    private String redirectURL;


}
