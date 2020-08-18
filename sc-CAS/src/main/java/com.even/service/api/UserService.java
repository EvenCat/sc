package com.even.service.api;

import com.even.common.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 北方、
 * @title: UserService
 * @projectName sc
 * @description: TODO
 * @date 2020/8/10 10:12
 */
@FeignClient(value = "sc-portal")
public interface UserService {

    @GetMapping("/user")
    public ResponseModel get();
}
