package com.yxj.ssmdemo.controller;

import com.yxj.ssmdemo.domain.Product;
import com.yxj.ssmdemo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/10
 * @version: 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * 查询所有产品信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        modelAndView.addObject("productList", products);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 产品添加
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }
}
