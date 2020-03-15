package com.yxj.service;

import com.yxj.domain.Account;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/9
 * @version: 1.0
 */
public interface IAccountService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户信息
     *
     * @param account
     */
    void saveAccount(Account account);
}
