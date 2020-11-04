package com.spring.bean.lifecycle;

/**
 * 在xml中配置init-method和destroy-method或使用注解配置，分别为bean初始化回调方法和bean销毁回调方法
 */
public class MyDestroyBean2 {
    public void init() {
        System.out.println("MyDestroyBean2 init");
    }

    public void destroy() {
        System.out.println("MyDestroyBean2 destroy");
    }
}
