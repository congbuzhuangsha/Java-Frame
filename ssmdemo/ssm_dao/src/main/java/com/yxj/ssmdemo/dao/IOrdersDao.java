package com.yxj.ssmdemo.dao;

import com.yxj.ssmdemo.domain.Member;
import com.yxj.ssmdemo.domain.Orders;
import com.yxj.ssmdemo.domain.Product;
import com.yxj.ssmdemo.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/12
 * @version: 1.0
 */
public interface IOrdersDao {
    /**
     * 查询所有订单信息
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.yxj.ssmdemo.dao.IProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;

    /**
     * 根据id查询订单信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.yxj.ssmdemo.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.yxj.ssmdemo.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = List.class,many = @Many(select = "com.yxj.ssmdemo.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String id)throws Exception;
}
