package com.openicu.boot.senior.aop;

import java.lang.annotation.*;

/**
 * @description:
 * @author: 云奇
 * @date: 2024/9/14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DefAop {

    /**
     * 模块描述
     * @return
     */
    String modelDesc();

    /**
     * 其他信息
     * @return
     */
    String otherInfo();


}
