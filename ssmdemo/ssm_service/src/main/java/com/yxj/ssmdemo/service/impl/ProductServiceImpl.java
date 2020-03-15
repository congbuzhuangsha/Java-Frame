package com.yxj.ssmdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.yxj.ssmdemo.dao.IProductDao;
import com.yxj.ssmdemo.domain.Product;
import com.yxj.ssmdemo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/10
 * @version: 1.0
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findAll() throws Exception {
        //PageHelper.startPage(1,3);
        return productDao.findAll();
    }

    /**
     * 产品添加
     * @param product
     */
    @Override
    public void save(Product product)throws Exception{
        productDao.save(product);
    }
}
