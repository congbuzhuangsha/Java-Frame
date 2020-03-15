package com.yxj.ssmdemo.controller;

import com.yxj.ssmdemo.domain.Role;
import com.yxj.ssmdemo.domain.UserInfo;
import com.yxj.ssmdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/14
 * @version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> users = userService.findAll();
        modelAndView.addObject("userList", users);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo user = userService.findById(id);
        modelAndView.addObject("user", user);
        System.out.println(user);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    /**
     * 用户添加
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(UserInfo user) throws Exception {
        userService.save(user);
        return "redirect:findAll.do";
    }

    /**
     * 通过id查询用户，通过id查询用户可添加的角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo user = userService.findById(id);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(id);
        modelAndView.addObject("user", user);
        modelAndView.addObject("roleList", otherRoles);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    /**
     * 为用户添加角色
     *
     * @param userId
     * @param roleIds
     * @return
     * @throws Exception
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(String userId, String[] roleIds) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        userService.addRoleToUser(userId, roleIds);
        modelAndView.setViewName("user-role-add");
        return "redirect:findAll.do";
    }
}
