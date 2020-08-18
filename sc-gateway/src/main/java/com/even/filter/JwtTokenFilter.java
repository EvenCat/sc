package com.even.filter;

import com.even.common.ResponseCode;
import com.even.common.ResponseModel;
import com.even.utils.ValideHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 北方、
 * @title: JwtTokenFilter
 * @projectName sc
 * @description: TODO
 * @date 2020/8/1 17:28
 */
//@Component
public class JwtTokenFilter implements GlobalFilter, Ordered {

    List<String> skipAuthUrls = new ArrayList<>();

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        //放行登录请求
//        if (JwtUtils.LOGIN_URL.equals(url)){
//            return chain.filter(exchange);
//        }
        /*//跳过不需要验证的路径
        if(null != skipAuthUrls&& Arrays.asList(skipAuthUrls).contains(url)){
            return chain.filter(exchange);
        }*/

        //获取token
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (ValideHelper.isNullOrEmpty(token)){
            url = "/login";
            ServerHttpResponse response = exchange.getResponse();
            //303状态码表示由于请求对应的资源存在着另一个URI，应使用GET方法定向获取请求的资源
//            response.setStatusCode(HttpStatus.valueOf(401));
//            response.getHeaders().set(HttpHeaders.LOCATION, url);
//            response.getHeaders().set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,"*");
            ResponseModel responseModel = new ResponseModel(ResponseCode.UNAUTHORIZED,"未登录");
            String returnStr = "";
            try {
                returnStr = objectMapper.writeValueAsString(responseModel);
            } catch (JsonProcessingException e) {
            }
            DataBuffer buffer = response.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
            return response.writeWith(Flux.just(buffer));
        }
        /*ServerHttpResponse resp = exchange.getResponse();
        Route gatewayUrl = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        String id = gatewayUrl.getId();
        exchange.getRequest().getCookies().forEach((s, httpCookies) -> {
            System.out.println("name:"+s);
            System.out.println("value:"+httpCookies);
        });*/

        return chain.filter(exchange);
        /*if(StringUtils.isEmpty(token)){
            //没有token 获取redirectURL 跳转登录页
            return authErro(resp,"请先登录",url+"/home");
        }else{
            //有token
            try {
                JwtUtils.checkToken(token,id);
                return chain.filter(exchange);
            }catch (ExpiredJwtException e){
//                log.error(e.getMessage(),e);
                if(e.getMessage().contains("Allowed clock skew")){
                    return authErro(resp,"认证过期",null);
                }else{
                    return authErro(resp,"认证失败",null);
                }
            }catch (Exception e) {
//                log.error(e.getMessage(),e);
                return authErro(resp,"认证失败",null);
            }
        }*/
//        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }


    /**
     * 认证错误输出
     * @param resp 响应对象
     * @param msg 错误信息
     * @return
     */
    private Mono<Void> authErro(ServerHttpResponse resp,String msg,Object data) {
//        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type","application/json;charset=UTF-8");
//        ReturnData<String> returnData = new ReturnData<>(org.apache.http.HttpStatus.SC_UNAUTHORIZED, mess, mess);
        ResponseModel responseModel = new ResponseModel(ResponseCode.UNAUTHORIZED,msg,data);
        String returnStr = "";
        try {
            returnStr = objectMapper.writeValueAsString(responseModel);
        } catch (JsonProcessingException e) {
//            log.error(e.getMessage(),e);
        }
        DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Flux.just(buffer));
    }

}
