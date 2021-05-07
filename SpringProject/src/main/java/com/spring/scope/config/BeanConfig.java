package com.spring.scope.config;

import com.spring.scope.bean.User2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    /**
     * 作用域
     * singleton 单例模式 ioc容器中只会存在一个共享的bean实例
     * prototype 原型模式 程序调用getBean方法时都会创建一个新的bean实例
     *
     */
    @Bean
    @Scope("prototype")
    public User2 user2() {
        return new User2("郑昭", 18);
    }
}
