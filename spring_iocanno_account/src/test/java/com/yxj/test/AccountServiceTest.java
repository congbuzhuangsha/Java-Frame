package com.yxj.test;

import com.yxj.domin.Account;
import com.yxj.service.IAccountService;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/5
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    //@Qualifier(value = "poxyAccountService")
    private IAccountService accountService;

    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindAccountById() {
        System.out.println(accountService.findAccountById(1));
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(1000f);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        account.setId(4);
        account.setName("test");
        account.setMoney(2000f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDeleteAccount() {
        accountService.deleteAccount(4);
    }

    @Test
    public void testTransfer() {
        accountService.transfer("aaa", "bbb", 100f);
    }
}
