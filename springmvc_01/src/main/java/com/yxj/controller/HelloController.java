package com.yxj.controller;

import com.yxj.com.yxj.SysException;
import com.yxj.domain.Account;
import com.yxj.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/8
 * @version: 1.0
 * 控制器类
 */
@Controller
@RequestMapping(value = "user")
@SessionAttributes("msg") //把msg存入到session域中一份
public class HelloController {
    //@RequestMapping注解的使用
    @RequestMapping(value = "hello", params = {"username=1"})
    public String sayHello(String username) {
        System.out.println("Hello SpringMVC" + username);
        return "success";
    }

    @RequestMapping(value = "submit", method = {RequestMethod.GET, RequestMethod.POST})
    public String submitTest(Account account) {
        System.out.println(account.getUsername() + account.getPassword() + account.getMoney());
        System.out.println(account.getUser().getAge());
        System.out.println(account);
        return "success";
    }
//**************************************************************

    /**
     * servlet原生API获取
     *
     * @return
     */
    @RequestMapping("testServlet")
    public String servlet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        session.getServletContext();
        return "success";
    }
    //***********************************************************
    //常用注解

    /**
     * @param username 必须传name参数
     * @return
     */
    @RequestMapping("requestParamTest")
    public String requestParamTest(@RequestParam("name") String username) {
        System.out.println(username);
        return "success";
    }

    /**
     * 获取请求体内容,requestHeader，cookieValue用法与其相同
     *
     * @param body
     * @return
     */
    @RequestMapping("requestBodyTest")
    public String requestBodyTest(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    /**
     * reset ful风格
     *
     * @return
     */
    @RequestMapping("pathVariableTest/{id}")
    public String pathVariableTest(@PathVariable("id") String id) {
        System.out.println(id);
        return "success";
    }

    /**
     * showUser在modelAttributeTest执行之前执行，可以用于补全表单提交信息，信息比对
     *
     * @return
     */
    @RequestMapping("modelAttributeTest")
    public String modelAttributeTest(@ModelAttribute("abc") User user) {
        System.out.println(user);
        return "success";
    }

//    /**
//     * 有返回值
//     * @param user
//     * @return
//     */
//    @ModelAttribute
//    public User showUser(User user){
//        user.setDate(new Date());
//        return user;
//    }

    @ModelAttribute
    public void showUser(User user, Map<String,User> map){
        user.setDate(new Date());
        map.put("abc", user);
    }

    /**
     * Model接口存，ModelMap实现类取，删除用SessionStatus.setComplete
     * @param model
     * @return
     */
    @RequestMapping("sessionAttributes")
    public String sessionAttributesTest(Model model){
        model.addAttribute("msg","11");
        return "success";
    }
    //****************************************************************
    //响应方式
    @RequestMapping("testString")
    public String testString(Model model){
        //模拟数据库中查询出User对象
        User user = new User();
        user.setUname("美美");
        user.setPassword("123");
        user.setAge(30);
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 返回值类型是void
     */
    @RequestMapping("testVoid")
    public void testVoid(HttpServletRequest request,HttpServletResponse response){
        //写法同servlet
    }

    @RequestMapping("testException")
    public String testException() throws SysException {

        try {
            int i =1/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有用户出现错误。。。");
        }

        return "success";
    }
}
