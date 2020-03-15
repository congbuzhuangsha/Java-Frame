package com.yxj.ssmdemo.controller;

import com.yxj.ssmdemo.domain.Permission;
import com.yxj.ssmdemo.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/12
 * @version: 1.0
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    /**
     * 查询所有产品信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissions = permissionService.findAll();
        modelAndView.addObject("permissionList", permissions);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    /**
     * 权限添加
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}
