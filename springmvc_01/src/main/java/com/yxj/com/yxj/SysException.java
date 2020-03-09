package com.yxj.com.yxj;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/9
 * @version: 1.0
 */
public class SysException extends Exception{
    //存储错误信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message) {
        this.message = message;
    }
}
