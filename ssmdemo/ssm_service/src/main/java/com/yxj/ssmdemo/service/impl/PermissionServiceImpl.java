package com.yxj.ssmdemo.service.impl;

import com.yxj.ssmdemo.dao.IPermissionDao;
import com.yxj.ssmdemo.dao.IRoleDao;
import com.yxj.ssmdemo.domain.Permission;
import com.yxj.ssmdemo.domain.Role;
import com.yxj.ssmdemo.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;
    /**
     * 查询所有权限信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    /**
     * 添加资源权限
     * @param permission
     * @throws Exception
     */
    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
