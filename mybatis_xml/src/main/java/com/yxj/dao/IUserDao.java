package com.yxj.dao;

import com.yxj.domain.QueryVo;
import com.yxj.domain.User;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/2/28
 * @version: 1.0
 * 用户的持久层接口
 */

public interface IUserDao {
    /**
     * 查询所有操作
     *
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param userId
     */
    void deleteUser(Integer userId);
/**************************************************************
    /**
     * 根据id查询用户
     *
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 模糊查询操作
     *
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查询总记录条数
     *
     * @return
     */
    int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);
//********************************************************************
    /**
     * 根据传入条件查询
     * @param user//查询条件：有可能有用户名。有可能有性别，有可能有地址。还有可能都没有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据query中提供的id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
    //**************************************************************
    //一对多
    //查询所有用户，同时获取到用户下所有账户的信息
    List<User> findAccount();
}
