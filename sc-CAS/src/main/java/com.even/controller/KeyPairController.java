package com.even.controller;

import com.even.common.ResponseModel;
import com.even.service.api.UserService;
import com.even.utils.SpringUtils;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @author 北方、
 * @title: KeyPairController
 * @projectName sc
 * @description: TODO
 * @date 2020/8/8 18:52
 */
@RestController
public class KeyPairController {

    @Autowired
    private KeyPair keyPair;

    @GetMapping("/rsa/publicKey")
    public Map<String, Object> getKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }

    @Autowired
    UserService userService;

    @RequestMapping(value = "/test")
    public ResponseModel test() {
        return ResponseModel.OK("hello");
    }

    @RequestMapping(value = "/user")
    public ResponseModel user() {
        return ResponseModel.OK("hello");
    }
}
