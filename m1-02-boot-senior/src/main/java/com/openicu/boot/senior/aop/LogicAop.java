package com.openicu.boot.senior.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: 云奇
 * @date: 2024/9/14
 */
@Component
@Aspect
public class LogicAop {

    private static final Logger logger = LoggerFactory.getLogger(LogicAop.class);

    @Pointcut("@annotation(com.openicu.boot.senior.aop.DefAop)")
    public void defAopPointCut(){}

    @Around("defAopPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = null;
        try{
            // 执行方法
            result = joinPoint.proceed();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 处理逻辑
            buildLogicAop(joinPoint);
        }

        return result;

    }

    /**
     * 构建处理逻辑
     * @param joinPoint
     */
    public void buildLogicAop(ProceedingJoinPoint joinPoint){
        // 获取方法
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();

        // 获取注解
        DefAop defAop = method.getAnnotation(DefAop.class);
        String modelDesc = defAop.modelDesc();
        String otherInfo = defAop.otherInfo();
        logger.info("DefAop-modelDesc：{}",modelDesc);
        logger.info("DefAop-otherInfo：{}",otherInfo);
    }


}
