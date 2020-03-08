package com.yxj.service.impl;

import com.yxj.dao.IAccountDao;
import com.yxj.domin.Account;
import com.yxj.service.IAccountService;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/5
 * @version: 1.0
 * 账户的业务层实现类
 * 事务的控制应该都是在业务层的
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();

    }

    /**
     * 查询一个
     *
     * @param accountId
     * @return
     */
    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    /**
     * 保存
     *
     * @param account
     */
    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    /**
     * 更新
     *
     * @param account
     */
    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    /**
     * 删除
     *
     * @param accountId
     */
    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    /**
     * 转账
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        //2.1.根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2.根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3.转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4.转入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5.更新转出账户
        accountDao.updateAccount(source);
        int i= 3/0;
        //2.6.更新转入账户
        accountDao.updateAccount(target);
    }
}
