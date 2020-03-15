package com.yxj.ssmdemo.dao;

import com.yxj.ssmdemo.domain.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/12
 * @version: 1.0
 */
public interface IMemberDao {
    /**
     * 查询所有会员信息
     * @return
     * @throws Exception
     */
    List<Member> findAll() throws Exception;

    /**
     * 根据id查询所有会员信息
     * @param memberId
     * @return
     * @throws Exception
     */
    @Select("select * from member where id=#{id}")
    Member findById(String memberId) throws Exception;
}
