package com.yxj.service.impl;

import com.yxj.dao.IAccountDao;
import com.yxj.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/4
 * @version: 1.0
 * 账户的业务层实现类
 */
@Service("accountService")//用于把当前类对象存入spring容器中,不写value时默认时当前类名，且首字母改小写
//Controller表现层 ui Service业务层 service  Repository持久层dao与component是一样的，时spring框架为我们提供mvc三层结构使用的
//@Scope("prototype")//作用范围
public class AccountServiceImpl implements IAccountService {
    @Autowired
    //自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
    //@Qualifier("accountDao1")
    //在按照类型注入的基础上在按照名称注入，再给类成员注入时不能单独使用，但是在给方法参数注入时可以

    //@Resource(name = "accountDao1")//直接按照bean的id注入，可以单独使用
    //以上三种注解都只能注入其他bean类型的数据，而基本类型和string类型无法使用上述注解实现
    //另外集合类型的注入只能通过xml实现
    private IAccountDao accountDao;
    @Value("张三")
    private String name;

    //@PostConstruct//用于指定初始化方法
    //@PreDestroy//用于指定销毁方法
    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(name);
    }
}
