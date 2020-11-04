package com.spring.bean.lifecycle;

/**
 * init方法为bean初始化回调方法，可以在xml中配置
 */
public class MyInitBean {
    public void init() {
        System.out.println("this is my init method");
    }
}
