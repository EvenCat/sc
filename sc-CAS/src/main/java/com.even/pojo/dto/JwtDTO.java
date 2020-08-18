package com.even.pojo.dto;

import lombok.Data;

/**
 * @author 北方、
 * @title: JwtDTO
 * @projectName sc
 * @description: TODO
 * @date 2020/8/1 18:21
 */
@Data
public class JwtDTO {

    /*用户id*/
    private Long userId;

    /*用户IP*/
    private String IP;

    /*发行人 服务的名称*/
    private String issuer;

    /*过期时间*/
    private Long ttlMillis;

    /*用户标识*/
    private String subject;
}
