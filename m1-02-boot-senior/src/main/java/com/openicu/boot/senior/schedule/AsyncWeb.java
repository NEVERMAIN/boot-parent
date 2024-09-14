package com.openicu.boot.senior.schedule;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/9/14
 */
@RestController
public class AsyncWeb {

    @Resource
    private AsyncService asyncService ;

    @GetMapping("/async")
    public String async (){
        asyncService.asyncJob();
        asyncService.asyncJobPool();
        return "OK-async" ;
    }
}
