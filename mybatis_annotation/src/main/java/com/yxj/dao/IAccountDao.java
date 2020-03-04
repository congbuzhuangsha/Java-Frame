package com.yxj.dao;

import com.yxj.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/3
 * @version: 1.0
 */
public interface IAccountDao {
    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     *
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(property = "uid",column = "uid"),
            @Result(property = "user", column = "uid", one =
            @One(select = "com.yxj.dao.IUserDao.findByUserId", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据id查询账户信息
     * @param uid
     * @return
     */
    @Select("select * from account where uid = #{uid}")
    List<Account> findAccountByUid(Integer uid);
}
