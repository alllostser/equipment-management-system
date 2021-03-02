package com.equipment.management.exception;

public class CommonException extends RuntimeException {
    private int code;
    private String msg;
 
    public CommonException(int code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }
 
    public int getCode() {
        return code;
    }
 
    public String getMsg() {
        return msg;
    }
}