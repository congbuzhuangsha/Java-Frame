package com.yxj.factory;

import com.yxj.service.IAccountService;
import com.yxj.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/7
 * @version: 1.0
 * 用于创建service的代理对象的工程
 */
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager txManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

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
                System.out.println("我来了");
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
