package com.yi23.springboot;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * 测试数据源
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDruidDatasource {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDruid(){
        System.out.println(dataSource);
    }


}
