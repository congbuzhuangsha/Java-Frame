package com.yxj.ssmdemo.service;

import com.yxj.ssmdemo.domain.Permission;
import com.yxj.ssmdemo.domain.Role;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/14
 * @version: 1.0
 */
public interface IPermissionService {
    /**
     * 查询所有权限信息
     * @return
     * @throws Exception
     */
    List<Permission> findAll() throws Exception;

    /**
     * 添加权限信息
     * @param permission
     * @throws Exception
     */
    void save(Permission permission)throws Exception;
}
