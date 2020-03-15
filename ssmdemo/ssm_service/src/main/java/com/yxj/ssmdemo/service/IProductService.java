package com.yxj.ssmdemo.service;

import com.github.pagehelper.Page;
import com.yxj.ssmdemo.domain.Product;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/10
 * @version: 1.0
 */
public interface IProductService {
    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;

    /**
     * 产品添加
     * @param product
     * @throws Exception
     */
    void save(Product product)throws Exception;
}
