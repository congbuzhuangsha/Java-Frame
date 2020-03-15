package com.yxj.ssmdemo.dao;

import com.yxj.ssmdemo.domain.Permission;
import com.yxj.ssmdemo.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/13
 * @version: 1.0
 */
public interface IRoleDao {
    /**
     * 根据用户id查询出所有对应的角色
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in(select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(property = "permissions",column = "id", javaType = List.class,many = @Many(select = "com.yxj.ssmdemo.dao.IPermissionDao.findByRoleId"))
    })
    List<Role> findRoleByUserId(String userId) throws Exception;

    /**
     * 查询所有角色信息
     * @return
     * @throws Exception
     */
    @Select("select * from role")
    List<Role> findAll()throws Exception;

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    @Insert("insert into role(roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role)throws Exception;

    /**
     * 通过id查询角色信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from role where id = #{id}")
    Role findById(String id)throws Exception;

    /**
     * 通过id查询角色可以添加的权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select * from permission where id not in(select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(String roleId)throws Exception;

    /**
     * 为角色添加权限
     * @param roleId
     * @param permissionId
     * @throws Exception
     */
    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addRoleToUser(@Param("roleId") String roleId, @Param("permissionId") String permissionId)throws Exception;
}
