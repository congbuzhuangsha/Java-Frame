package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/7
 * @version: 1.0
 * 和事务相关的配置类
 */
public class TransactionConfig {
    /**
     * 用于创建事务管理器对象
     * @param dataSource
     * @return
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager createTransactionManager(@Qualifier("dataSourceProxy") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
