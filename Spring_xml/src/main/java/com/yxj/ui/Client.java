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
     * 获取spring容器的ioc核心容器，并根据id获取对象
     * applicationContext的三个常用类
     *      ClassPathXmlApplicationContext:它可以加载类路径下的配置文件，要求文件必须在类路径下，不在的话加载不了
     *      FileSystemApplicationContext：它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的
     *
     * 核心容器的两个接口引发出的问题：
     * ApplicationContext：单例对象适用
     *      它是在构建核心容器时，创建对象采用的策略时立即加载的方式。也就是说，只要一读取配置文件马上就创建配置文件中配置的对象
     *BeanFactory：多例对象适用
     *      它是在构建核心容器时，创建对象采用的策略时延迟加载的方式。也就是说，什么时候根据id获取对象了什么时候才真正的创建对象
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountService.saveAccount();

        IAccountService accountService2 = (IAccountService) applicationContext.getBean("accountService2");
        accountService2.saveAccount();
        IAccountService accountService3 = (IAccountService) applicationContext.getBean("accountService3");
        accountService3.saveAccount();


    }
}
