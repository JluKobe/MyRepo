package com.spring.bean.lifecycle;

import org.springframework.beans.factory.InitializingBean;

/**
 * 类实现InitializingBean接口，重写afterPropertiesSet方法，该方法为bean初始化回调方法
 */
public class MyInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("this is my myInitializingBean method");
    }
}
