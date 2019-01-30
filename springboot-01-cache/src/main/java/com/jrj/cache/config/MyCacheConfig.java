package com.jrj.cache.config;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class MyCacheConfig {
//
//    @Bean("myKeyGenerator")
//    public KeyGenerator keyGenerator(){
//        return new KeyGenerator(){
//
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                return method.getName()+"["+ Arrays.asList(params).toString()+"]";
//            }
//        };
//    }
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactoryBean() throws IOException {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        bean.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
//        bean.setTypeAliasesPackage("com.shanlin.mybatis");
//
//        //bean.setDataSource(dataSource);
//        bean.setPlugins(new Interceptor[]{ new MybatisInterceptor()});
//        try {
//            return bean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }

//    @Bean
//    public Interceptor createInterceptor(REgister){
//
//    }


}
