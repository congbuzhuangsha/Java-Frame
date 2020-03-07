package com.yxj.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/6
 * @version: 1.0
 * 连接的工具类，用于从数据源中获取一个连接，并且实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection(){
        try {
            //1.先从ThreadLocal上获取
            Connection connection = threadLocal.get();
            //2.判断当前线程上是否有连接
            if (connection == null){
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            //4.返回当前线程上的连接
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        threadLocal.remove();
    }
}

