package com.yxj.ui;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/7
 * @version: 1.0
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
@Component
@Aspect//表示当前类是一个切面类
@EnableAspectJAutoProxy
public class Logger {

    @Pointcut("execution(* com.yxj.service.impl.*.*(..))")
    private void pc(){

    }


    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    @Before("pc()")//前置
    @AfterReturning("pc()")//后置
    @AfterThrowing("pc()")//异常
    @After("pc()")//最终
    private void printLog(){
        System.out.println("打印日志啦！！！");
    }


    @Around("pc()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue= null;
        try {
            Object[] args= pjp.getArgs();
            System.out.println("前置");
            rtValue = pjp.proceed(args);//明确调用业务层方法，切入点方法
            System.out.println("后置");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("异常");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("最终");
        }
    }
}
