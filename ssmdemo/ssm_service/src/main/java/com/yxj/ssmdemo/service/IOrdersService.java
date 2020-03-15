package com.yxj.ssmdemo.service;


import com.yxj.ssmdemo.domain.Orders;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/12
 * @version: 1.0
 */
public interface IOrdersService {
    /**
     * 查询所有订单信息
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int page,int size) throws Exception;

    /**
     * 通过Id查询订单详情
     * @param id
     * @return
     */
    Orders findById(String id) throws Exception;
}
