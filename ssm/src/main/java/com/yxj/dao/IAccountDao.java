package com.yxj.dao;

import com.yxj.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/9
 * @version: 1.0
 */
@Repository
public interface IAccountDao {

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存账户信息
     *
     * @param account
     */
    @Insert("insert into account(name,money) values (#{name},#{money})")
    void saveAccount(Account account);
}
