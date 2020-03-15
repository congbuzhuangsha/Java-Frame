package com.yxj.ssmdemo.dao;

import com.yxj.ssmdemo.domain.Permission;
import com.yxj.ssmdemo.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/14
 * @version: 1.0
 */
public interface IPermissionDao {
    /**
     * 根据角色id查询资源权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findByRoleId(String roleId) throws Exception;

    /**
     * 查询所有资源权限信息
     * @return
     * @throws Exception
     */
    @Select("select * from permission")
    List<Permission> findAll()throws Exception;

    /**
     * 添加资源权限
     * @param permission
     * @throws Exception
     */
    @Insert("insert into permission(permissionName,url) values (#{permissionName},#{url})")
    void save(Permission permission)throws Exception;
}
