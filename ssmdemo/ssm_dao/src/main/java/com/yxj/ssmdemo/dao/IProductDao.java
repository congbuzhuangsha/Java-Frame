package com.yxj.ssmdemo.dao;

import com.yxj.ssmdemo.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/10
 * @version: 1.0
 *
 */
public interface IProductDao {
    /**
     * 根据id查询产品
     * @return
     * @throws Exception
     */
    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;
    /**
     * 查询所有的产品信息
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 产品添加
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product)throws Exception;
}
