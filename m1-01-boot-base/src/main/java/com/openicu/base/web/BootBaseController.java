package com.openicu.base.web;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 云奇
 * @date: 2024/9/14
 */
@RestController
public class BootBaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BootBaseController.class);

    @GetMapping("/boot/base/{id}")
    public Map<String,String> getInfo(@PathVariable String id){
        if(StringUtils.isBlank( id) || "0".equals(id)){
            throw new RuntimeException("参数ID错误");
        }
        var dataMap = new HashMap<String,String>();
        dataMap.put("id", id);
        dataMap.put("boot", "base");
        return dataMap;
    }


    @GetMapping("/boot/print/log")
    public String printLog (HttpServletRequest request){
        LOGGER.info("remote-host:{}",request.getRemoteHost());
        LOGGER.info("request-uri:{}",request.getRequestURI());
        return request.getServerName() ;
    }

}
