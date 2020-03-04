package com.yxj.dao;

import com.yxj.domain.Account;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/2
 * @version: 1.0
 */
public interface IAccountDao {
    //多对一
    /**
     * 查询所有,同时还要获取当前用户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    List<Account> findAccountByUid(Integer uid);

}
