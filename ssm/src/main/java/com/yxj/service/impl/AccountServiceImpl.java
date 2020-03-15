package com.yxj.service.impl;

import com.yxj.dao.IAccountDao;
import com.yxj.domain.Account;
import com.yxj.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/9
 * @version: 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    /**
     * 保存账户信息
     *
     * @param account
     */
    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }
}
