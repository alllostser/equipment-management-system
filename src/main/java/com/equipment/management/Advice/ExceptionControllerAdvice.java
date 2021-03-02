package com.equipment.management.Advice;


import cn.hutool.json.JSONObject;
import com.equipment.management.exception.CommonException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
 
/**
 * 全局异常捕捉类
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
 
    /*
       捕捉自定义的CommonException异常
     */
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public JSONObject CommonExceptionHandler(CommonException e) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",e.getCode());
        jsonObject.put("msg",e.getMsg());
        return jsonObject;
    }
}
