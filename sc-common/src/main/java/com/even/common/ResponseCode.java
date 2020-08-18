package com.even.common;

/**
 * @author 北方、
 * @title: ResponseCode
 * @projectName project
 * @description: TODO
 * @date 2020/7/30 14:50
 */
public enum ResponseCode {
    // 成功
    SUCCESS(200),

    // 失败
    FAIL(400),

    REDIRECT(302),

    // 未认证（签名错误）
    UNAUTHORIZED(401),

    // 没有资源访问权限
    NO_ACCESS_RIGHTS(403),

    // 接口不存在
    NOT_FOUND(404),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResponseCode(int code) {
        this.code = code;
    }

}
