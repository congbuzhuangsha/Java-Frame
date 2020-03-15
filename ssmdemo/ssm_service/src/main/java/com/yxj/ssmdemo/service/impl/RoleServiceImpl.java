package com.yxj.ssmdemo.service.impl;

import com.yxj.ssmdemo.dao.IRoleDao;
import com.yxj.ssmdemo.domain.Permission;
import com.yxj.ssmdemo.domain.Role;
import com.yxj.ssmdemo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/14
 * @version: 1.0
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;
    /**
     * 查询所有角色信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    /**
     * 通过id查询角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    /**
     * 通过id查询可添加的资源权限
     *
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    /**
     * 为角色添加资源权限
     *
     * @param roleId
     * @param permissionIds
     */
    @Override
    public void addRoleToUser(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addRoleToUser(roleId, permissionId);
        }
    }
}
