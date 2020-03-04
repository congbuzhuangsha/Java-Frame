package com.yxj.test;

import com.yxj.dao.IUserDao;
import com.yxj.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/2/29
 * @version: 1.0
 */
public class MybatisTest {
    private InputStream inputStream;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //3.使用工厂生产SqlSession对象
        session = factory.openSession();
        //清空缓存
        //session.clearCache();
        //自动提交
        //session = factory.openSession(true);
        //4.使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        //6.释放资源
        session.close();
        inputStream.close();
    }

    /**
     * 入门案例
     */
    @Test
    public void testFingAll() {
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("张三");
        user.setAddress("山东省烟台市");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println(user);
        userDao.saveUser(user);
        System.out.println(user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(55);
        user.setUsername("李四");
        user.setAddress("山东省烟台市");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(42);
    }
//***********************************************************************
    @Test
    public void testFindOne() {
        User user = userDao.findById(41);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int count = userDao.findTotal();
        System.out.println(count);
    }

    @Test
    public void findUserByVo() {
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        List<User> users = userDao.findUserByVo(queryVo);
        for (User u : users) {
            System.out.println(u);
        }
    }
    //**************************************************************************
    @Test
    public void testFindByCondition(){
        User u=new User();
        u.setUsername("老王");
        u.setSex("男");
        List<User> users = userDao.findUserByCondition(u);
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testFindInIds(){
        QueryVo vo=new QueryVo();
        List<Integer> list=new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(43);
        vo.setIds(list);

        List<User> users = userDao.findUserInIds(vo);
        for (User user:users){
            System.out.println(user);
        }
    }
//******************************************************************
    @Test
    public void testFindAccount(){
        List<User> users=userDao.findAccount();
        for (User user:
             users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
}
