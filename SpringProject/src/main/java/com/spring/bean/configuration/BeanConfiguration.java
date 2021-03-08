package com.spring.bean.configuration;

import com.spring.bean.lifecycle.MyDestroyBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用注解配置bean初始化回调方法和销毁回调方法
 */
@Configuration
public class BeanConfiguration {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public MyDestroyBean2 myDestroyBean2() {
        System.out.println("testtesttest");
        System.out.println("test");
        return new MyDestroyBean2();
    }
}
