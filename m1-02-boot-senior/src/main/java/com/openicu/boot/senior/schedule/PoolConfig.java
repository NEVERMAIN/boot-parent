package com.openicu.boot.senior.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 自定义线程池配置
 * @author: 云奇
 * @date: 2024/9/14
 */
@Configuration
public class PoolConfig {

    @Bean("asyncPool")
    public Executor asyncPool(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 线程池命名前缀
        executor.setThreadNamePrefix("async-pool-");
        // 核心线程数5
        executor.setCorePoolSize(5);
        // 最大线程池
        executor.setMaxPoolSize(10);
        // 缓冲执行任务队列 50
        executor.setQueueCapacity(50);
        // 现成的空闲时间 60s
        executor.setKeepAliveSeconds(60);
        // 线程池对拒绝任务的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 线程池关闭的时候等待所有任务都完成再继续销毁其他的 bean
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置线程池中任务的等待时间
        executor.setAwaitTerminationSeconds(300);

        return executor;
    }


}
