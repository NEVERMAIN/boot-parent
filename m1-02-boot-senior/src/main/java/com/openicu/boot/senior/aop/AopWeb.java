package com.openicu.boot.senior.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/9/14
 */
@RestController
public class AopWeb {

    @GetMapping("/aop/web1")
    @DefAop(modelDesc="Aop测试1",otherInfo="其他信息")
    public String aopWeb1(){
        return "aop-web" ;
    }
}