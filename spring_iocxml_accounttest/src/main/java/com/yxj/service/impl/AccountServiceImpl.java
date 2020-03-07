package com.yxj.service.impl;

import com.yxj.dao.IAccountDao;
import com.yxj.domin.Account;
import com.yxj.service.IAccountService;
import com.yxj.utils.TransactionManager;

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
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

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
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accounts;
        } catch (Exception e) {
            //回滚操作
            txManager.rollback();
            throw new RuntimeException();
        } finally {
            //释放资源
            txManager.release();
        }
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
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
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
                int s=3/0;
                //2.6.更新转入账户
                accountDao.updateAccount(target);
            //3.提交事务
            txManager.commit();
        } catch (Exception e) {
            //回滚操作
            txManager.rollback();
            throw new RuntimeException();
        } finally {
            //释放资源
            txManager.release();
        }
    }
}
