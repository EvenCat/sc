package com.even.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 北方、
 * @title: UserDTO
 * @projectName sc
 * @description: TODO
 * @date 2020/8/9 10:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String username;

    private String password;

    private Integer status;

    private List<String> roles;

}
