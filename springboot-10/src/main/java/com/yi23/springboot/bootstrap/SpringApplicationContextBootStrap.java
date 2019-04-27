package com.yi23.springboot.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link SpringApplication} 应用上下文引导类
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 * @see
 * @since
 */
//@SpringBootApplication
public class SpringApplicationContextBootStrap {

    @Autowired
    public ServletWebServerApplicationContext servletWebServerApplicationContext() {
        return new ServletWebServerApplicationContext();
    }

    public void main() {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(SpringApplicationContextBootStrap.class)
                        .web(WebApplicationType.SERVLET)
                        .sources(TomcatServletWebServerFactory.class)
                        .sources(ServletWebServerApplicationContext.class)
                        .run();

        System.out.println("ConfigurableApplicationContext 类型："
                + context.getClass().getName());
        System.out.println("Environment 类型："
                + context.getEnvironment().getClass().getName());

        //关闭上下文
       // context.close();
    }

    public static void main(String[] args) {
        SpringApplicationContextBootStrap a = new SpringApplicationContextBootStrap();
        a.main();
        System.out.println("aaa");

    }
}

class aa {
    public static void main(String[] args) {
//        System.out.println("aaa");

    }

}