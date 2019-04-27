package com.yi23.springboot.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 配置druid数据库连接池
 */

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DruidConfig {

    String filters;

    Integer maxActive ,initialSize ,maxWait ,maxIdle, minIdle ,timeBetweenEvictionRunsMillis,minEvictableIdleTimeMillis,maxOpenPreparedStatements;
    String validationQuery,password,username,url,driverClassName;
    Boolean testWhileIdle,testOnBorrow,testOnReturn,poolPreparedStatements,logSlowSql;

    @Bean("dataSource")
    public DataSource createDataSource() throws Exception{

        DruidDataSource dataSource=new DruidDataSource();
        /**
         * 最大连接数
         */
        dataSource.setMaxActive(maxActive);
        /**
         * 初始化大小
         */
        dataSource.setInitialSize(initialSize);
        /**
         * 最长等待时间
         */
        dataSource.setMaxWait(maxWait);
        /**
         * 最大闲置数
         */
        dataSource.setMaxIdle(maxIdle);
        /**
         * 最小闲置数
         */
        dataSource.setMinIdle(minIdle);
        /**
         * 配置间隔多久采进行一次检查，检查需要关闭的空闲的连接，单位为毫秒
         */
        dataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        /**
         * 配置一个连接在连接池中的最小存活时间，单位为毫秒
         */
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        /**
         *
         */
        dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        /**
         * 用来检测连接是否有效的sql，要求是一个查询语句。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会其作用。
         */
        dataSource.setValidationQuery(validationQuery);
        /**
         * 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
         */
        dataSource.setTestOnReturn(testOnReturn);
        /**
         * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
         */
        dataSource.setTestOnBorrow(testOnBorrow);
        /**
         * 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
         */
        dataSource.setTestWhileIdle(testWhileIdle);
        /**
         * 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有： 监控统计用的filter:stat日志用的filter:log4j防御sql注入的filter:wall
         */
        dataSource.setFilters(filters);

        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }


}
