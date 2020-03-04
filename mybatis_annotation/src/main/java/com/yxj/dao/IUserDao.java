package com.yxj.dao;

import com.yxj.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/3
 * @version: 1.0
 */
public interface IUserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(property = "accounts", column = "id", many = @Many(
                    select = "com.yxj.dao.IAccountDao.findAccountByUid",
                    fetchType = FetchType.LAZY))
    })
    //解决名字不对应
    //@ResultMap("userMap")
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);

    /**
     * 根据id删除用户
     *
     * @param userId
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     *
     * @param userId
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findByUserId(Integer userId);

    /**
     * 模糊查询
     *
     * @param username
     * @return
     */
//    @Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%'")
    List<User> findByName(String username);

    @Select("select count(id) from user")
    int findTotalUser();

    @Select("select * from user")
    @ResultMap("userMap")
    List<User> findAllAccount();
}
