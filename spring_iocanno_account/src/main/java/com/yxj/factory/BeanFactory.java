package com.yxj.factory;

import com.yxj.service.IAccountService;
import com.yxj.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/7
 * @version: 1.0
 * 用于创建service的代理对象的工程
 */
@Component("beanFactory")
public class BeanFactory {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private TransactionManager txManager;

    @Bean("poxyAccountService")
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 添加事务的支持
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue;
                try {
                    //1.开启事务
                    txManager.beginTransaction();
                    //2.执行操作
                    returnValue = method.invoke(accountService, args);
                    //3.提交事务
                    txManager.commit();
                } catch (Exception e) {
                    //回滚操作
                    txManager.rollback();
                    throw new RuntimeException();
                } finally {
                    //释放资源
                    txManager.release();
                }
                return returnValue;
            }
        });
    }
}
