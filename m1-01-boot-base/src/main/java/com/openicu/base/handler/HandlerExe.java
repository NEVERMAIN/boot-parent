package com.openicu.base.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 云奇
 * @date: 2024/9/14
 */
@RestControllerAdvice
public class HandlerExe {

    @ExceptionHandler(value = Exception.class)
    public Map<String,String> handlerException(HttpServletRequest request, Exception e){
        var errorMap = new HashMap<String,String>() ;
        errorMap.put("code","500");
        errorMap.put("url",request.getRequestURL().toString());
        errorMap.put("msg",e.getMessage());
        return errorMap ;
    }


}
