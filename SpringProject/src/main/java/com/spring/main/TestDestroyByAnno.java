package com.spring.main;

import com.spring.bean.configuration.BeanConfiguration;
import com.spring.bean.lifecycle.MyDestroyBean2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * 使用AbstractApplicationContext创建context，使用registerShutdownHook方法调用bean销毁回调方法
 */
public class TestDestroyByAnno {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        MyDestroyBean2 bean = context.getBean(MyDestroyBean2.class);
        context.registerShutdownHook();
    }
}
