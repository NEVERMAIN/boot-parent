package com.openicu.boot.senior.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description: 异步任务
 * @author: 云奇
 * @date: 2024/9/14
 */
@Service
public class AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void asyncJob(){
        try{
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        logger.info("async-job-01-end...");
    }

    @Async("asyncPool")
    public void asyncJobPool (){
        try{
            TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        logger.info("async-job-02-end...");
    }


}
