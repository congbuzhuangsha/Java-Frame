package com.yxj.dao;

import com.yxj.domain.Role;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/2
 * @version: 1.0
 */
public interface IRoleDao {
    List<Role> findAll();
}
