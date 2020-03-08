package com.yxj.ui;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/7
 * @version: 1.0
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {
    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    private void printLog(){
        System.out.println("打印日志啦！！！");
    }

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
