package com.yxj;

import com.yxj.dao.IAccountDao;
import com.yxj.domain.Account;
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
public class AccountTest {
    private InputStream inputStream;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;


    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        inputStream.close();
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
