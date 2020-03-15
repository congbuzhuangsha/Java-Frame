package com.yxj.ssmdemo.service.impl;

import com.yxj.ssmdemo.dao.IUserDao;
import com.yxj.ssmdemo.domain.Role;
import com.yxj.ssmdemo.domain.UserInfo;
import com.yxj.ssmdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/13
 * @version: 1.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {


    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),userInfo.getStatus()== 0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }


    /**
     * 查询所有用户信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    /**
     * 添加新用户
     *
     * @param user
     */
    @Override
    public void save(UserInfo user) throws Exception {
        //对密码进行加密处理
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    /**
     * 查询用户可以添加的角色
     *
     * @param userId
     * @return
     */
    @Override
    public List<Role> findOtherRoles(String userId) throws Exception {
        return userDao.findOtherRoles(userId);
    }

    /**
     * 为用户添加角色
     *
     * @param userId
     * @param roleIds
     */
    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception{
        for (String roleId : roleIds)
        userDao.addRoleToUser(userId,roleId);
    }
}
