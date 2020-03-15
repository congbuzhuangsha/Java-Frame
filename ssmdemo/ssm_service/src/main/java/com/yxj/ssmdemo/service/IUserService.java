package com.yxj.ssmdemo.service;

import com.yxj.ssmdemo.domain.Role;
import com.yxj.ssmdemo.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/13
 * @version: 1.0
 */
public interface IUserService extends UserDetailsService {
    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    UserInfo findById(String id)throws Exception;

    /**
     * 添加新用户
     * @param user
     */
    void save(UserInfo user)throws Exception;

    /**
     * 查询用户可以添加的角色
     * @param userId
     * @return
     */
    List<Role> findOtherRoles(String userId)throws Exception;

    /**
     * 为用户添加角色
     * @param userId
     * @param roleIds
     */
    void addRoleToUser(String userId, String[] roleIds)throws Exception;
}
