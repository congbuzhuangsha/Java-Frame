package com.yxj.com.yxj;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/9
 * @version: 1.0
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常的业务逻辑
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取到异常对象
        SysException exception = null;
        if (e instanceof SysException) {
            exception = (SysException) e;
        } else {
            exception = new SysException("系统正在维护。。。");
        }
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", exception.getMessage());//放到request中
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
