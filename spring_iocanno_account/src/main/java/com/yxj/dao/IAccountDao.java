package com.yxj.dao;

import com.yxj.domin.Account;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/5
 * @version: 1.0
 * 账户的持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     *
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     */
    void saveAccount(Account account);

    /**
     * 更新
     *
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     *
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    Account findAccountByName(String targetName);
}
