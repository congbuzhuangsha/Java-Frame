package com.yxj.ssmdemo.service;

import com.yxj.ssmdemo.domain.Permission;
import com.yxj.ssmdemo.domain.Role;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/14
 * @version: 1.0
 */
public interface IRoleService {
    /**
     * 查询所有角色信息
     * @return
     * @throws Exception
     */
    List<Role> findAll() throws Exception;

    /**
     * 添加角色信息
     * @param role
     * @throws Exception
     */
    void save(Role role)throws Exception;

    /**
     * 通过id查询角色
     * @param id
     * @return
     * @throws Exception
     */
    Role findById(String id)throws Exception;

    /**
     * 通过id查询可添加的资源权限
     * @param id
     * @return
     */
    List<Permission> findOtherPermissions(String id)throws Exception;

    /**
     * 为角色添加资源权限
     * @param roleId
     * @param permissionIds
     */
    void addRoleToUser(String roleId, String[] permissionIds)throws Exception;
}
