package com.yxj.ssmdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.yxj.ssmdemo.dao.IOrdersDao;
import com.yxj.ssmdemo.domain.Orders;
import com.yxj.ssmdemo.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/12
 * @version: 1.0
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;

    /**
     * 查询所有订单信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //哪一页，每页多少条
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    /**
     * 通过Id查询订单详情
     *
     * @param id
     * @return
     */
    @Override
    public Orders findById(String id) throws Exception{
        return ordersDao.findById(id);
    }
}
