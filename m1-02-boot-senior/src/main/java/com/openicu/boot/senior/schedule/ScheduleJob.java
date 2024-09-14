package com.openicu.boot.senior.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: 云奇迹
 * @date: 2024/9/14
 */
@Component
public class ScheduleJob {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleJob.class);

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;

    /**
     * 上一次开始执行时间点之后10秒再执行
     */
    @Scheduled(fixedRate = 10000)
    private void timerJob1(){
        logger.info("timer-job-1:{}",format.format(new Date()));
    }

    /**
     * 上一次执行完毕时间点之后10秒再执行
     */
    @Scheduled(fixedDelay = 10000)
    private void timerJob2(){
        logger.info("timer-job-2:{}",format.format(new Date()));
    }

    /**
     * Cron表达式：每30秒执行一次
     */
    @Scheduled(cron = "0/30 * * * * ?")
    private void timerJob3(){
        logger.info("timer-job-3:{}",format.format(new Date()));
    }

}
