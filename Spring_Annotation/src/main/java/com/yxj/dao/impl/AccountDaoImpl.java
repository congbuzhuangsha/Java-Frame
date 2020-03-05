package com.yxj.dao.impl;

import com.yxj.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/4
 * @version: 1.0
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了一个账户");
    }
}
