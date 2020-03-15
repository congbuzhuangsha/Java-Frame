package com.yxj.ssmdemo.controller;

import com.github.pagehelper.PageInfo;
import com.yxj.ssmdemo.domain.Orders;
import com.yxj.ssmdemo.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/12
 * @version: 1.0
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    /**
     * 查询所有产品信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size", defaultValue = "4") int size) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> orders = ordersService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(orders);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ordersService.findById(id);
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
