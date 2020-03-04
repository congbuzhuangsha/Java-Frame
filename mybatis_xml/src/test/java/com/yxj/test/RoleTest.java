package com.yxj.test;

import com.yxj.dao.IRoleDao;
import com.yxj.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/2/29
 * @version: 1.0
 */
public class RoleTest {
    private InputStream inputStream;
    private SqlSession session;
    private IRoleDao roleDao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //自动提交
        //session = factory.openSession(true);
        //4.使用SqlSession创建Dao接口的代理对象
        roleDao = session.getMapper(IRoleDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        //6.释放资源
        session.close();
        inputStream.close();
    }
    //查询角色获得所有用户信息
    @Test
    public void testFindAll() {
        List<Role> roles = roleDao.findAll();
        for (Role role:roles) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}