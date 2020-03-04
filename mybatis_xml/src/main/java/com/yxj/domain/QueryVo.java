package com.yxj.domain;

import java.util.List;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/2/29
 * @version: 1.0
 */
public class QueryVo {
    private User user;

    public User getUser() {
        return user;
    }

    private List<Integer> ids;

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
