package com.spring.bean.lifecycle;

import org.springframework.beans.factory.DisposableBean;

/**
 * 实现DisposableBean接口，重写destroy方法，该方法为bean销毁回调方法
 */
public class MyDestroyBean1 implements DisposableBean {

    @Override
    public void destroy() {
        System.out.println("this is my MyDestroyBean destroy");
    }
}
