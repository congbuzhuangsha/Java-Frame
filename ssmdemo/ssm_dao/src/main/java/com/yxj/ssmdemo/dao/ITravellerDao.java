package com.yxj.ssmdemo.dao;

import com.yxj.ssmdemo.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/12
 * @version: 1.0
 */
public interface ITravellerDao {
    /**
     * 通过订单id查询游客
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
