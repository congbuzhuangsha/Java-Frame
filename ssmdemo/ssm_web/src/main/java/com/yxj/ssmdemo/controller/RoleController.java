package com.yxj.ssmdemo.controller;

import com.yxj.ssmdemo.domain.Permission;
import com.yxj.ssmdemo.domain.Role;
import com.yxj.ssmdemo.domain.UserInfo;
import com.yxj.ssmdemo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/14
 * @version: 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    /**
     * 查询所有角色信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.findAll();
        modelAndView.addObject("roleList", roles);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    /**
     * 角色添加
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    /**
     * 通过id查询角色，通过id查询角色可添加的权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //1.根据用户id查询用户
        Role role = roleService.findById(id);
        //2.根据用户id查询可以添加的角色
        List<Permission> otherPermissions = roleService.findOtherPermissions(id);
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", otherPermissions);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    /**
     * 为用户添加角色
     *
     * @param roleId
     * @param permissionIds
     * @return
     * @throws Exception
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(String roleId, String[] permissionIds) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        roleService.addRoleToUser(roleId, permissionIds);
        modelAndView.setViewName("role-permission-add");
        return "redirect:findAll.do";
    }
}
