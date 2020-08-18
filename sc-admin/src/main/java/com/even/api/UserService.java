package com.even.api;

import com.even.common.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author 北方、
 * @title: UserService
 * @projectName sc
 * @description: TODO
 * @date 2020/8/10 21:58
 */
@FeignClient("sc-cas")
public interface UserService {

    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public ResponseModel getToken(@RequestParam Map<String,String> map);
}
