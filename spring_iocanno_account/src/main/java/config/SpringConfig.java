package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/5
 * @version: 1.0
 * 该类是一个配置类，他的作用和bean.xml是一样的
 * spring中的新注解
 * 细节：当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象
 * 查找的方式和Autowired注解的作用是一样的
 */
//@Configuration//制定当前类是一个配置类,当配置类作为AnnotationConfigContext对象创建的参数时，该注解可以不写
@ComponentScan("com.yxj")//用于通过注解指定spring在创建容器时要扫描的包
@Import(JdbcConfig.class)//用于导入其他的配置类
@PropertySource("classpath:jdbcConfig.properties")//指定properties文件的位置，文件的名称和路径classpath类路径下
public class SpringConfig {

}
