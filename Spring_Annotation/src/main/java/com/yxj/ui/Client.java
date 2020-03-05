package com.yxj.ui;

import com.yxj.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/4
 * @version: 1.0
 * 模拟表现层，用于调用业务层
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountService.saveAccount();
    }
}
