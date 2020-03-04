package com.yxj;

import com.yxj.dao.IUserDao;
import com.yxj.domain.Account;
import com.yxj.domain.User;
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
 * @Date: 2020/3/3
 * @version: 1.0
 */
public class MybatisAnnoTest {
    private InputStream inputStream;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        inputStream.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("李四");
        user.setAddress("北京市");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(56);
        user.setUsername("张三");
        user.setAddress("天津市");
        userDao.saveUser(user);
    }

    @Test
    public void testDeleteUser() {
        userDao.deleteUser(57);
    }

    @Test
    public void testFindUserById() {
        System.out.println(userDao.findByUserId(41));

    }

    @Test
    public void testFindByName() {
//        List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findByName("王");
        for (User user : users
        ) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotalUser() {
        System.out.println(userDao.findTotalUser());
    }

    @Test
    public void testFindAccount() {
        List<User> users = userDao.findAllAccount();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

}
