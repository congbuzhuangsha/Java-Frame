package com.yxj.ssmdemo.dao;

import com.yxj.ssmdemo.domain.Role;
import com.yxj.ssmdemo.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/13
 * @version: 1.0
 */
public interface IUserDao {
    /**
     * 根据用户名查询用户信息，包括所有角色信息，用于登录验证
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username = #{username}")
    @Results(id = "user", value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class, many = @Many(select = "com.yxj.ssmdemo.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username) throws Exception;

    /**
     * 查询所有用户信息
     *
     * @return
     * @throws Exception
     */
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 根据id查询用户信息，包括角色和资源权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from users where id = #{id}")
    @ResultMap("user")
    UserInfo findById(String id) throws Exception;

    /**
     * 添加新用户
     *
     * @param user
     */
    @Insert("insert into USERS(email, username, password, phoneNum, status) VALUES (#{email}, #{username}, #{password}, #{phoneNum}, #{status})")
    void save(UserInfo user) throws Exception;

    /**
     * 查询用户可以添加的角色
     *
     * @param userId
     * @return
     */
    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(String userId) throws Exception;

    /**
     * @param userId
     * @param roleId
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId")String userId, @Param("roleId")String roleId)throws Exception;
}
