package com.even.common;

/**
 * @author 北方、
 * @title: ResponseModel
 * @projectName project
 * @description: TODO
 * @date 2020/7/30 14:45
 */
public class ResponseModel<T> {

    private int stateCode;

    private String msg;

    private T data;

    public static ResponseModel OK(String msg){
        return new ResponseModel(ResponseCode.SUCCESS,msg);
    }

    public static <T> ResponseModel OK(String msg, T data){
        return new ResponseModel(ResponseCode.SUCCESS,msg,data);
    }

    public ResponseModel(){

    }

    public ResponseModel(ResponseCode stateCode, String msg){
        this.stateCode = stateCode.code;
        this.msg = msg;
    }

    public ResponseModel(ResponseCode stateCode, String msg, T data){
        this.stateCode = stateCode.code;
        this.msg = msg;
        this.data = data;
    }

    public int getStateCode() {
        return stateCode;
    }

    public ResponseModel setStateCode(int stateCode) {
        this.stateCode = stateCode;
        return this;
    }

    public ResponseModel setStateCode(ResponseCode stateCode) {
        this.stateCode = stateCode.code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseModel setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseModel setData(T data) {
        this.data = data;
        return this;
    }
}
