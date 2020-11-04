package com.spring.main;

import com.spring.bean.lifecycle.MyDestroyBean1;
import com.spring.bean.lifecycle.MyDestroyBean2;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DestroyMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeansDestroy.xml");

        MyDestroyBean1 bean = (MyDestroyBean1) context.getBean("myDestroyBean");
        MyDestroyBean2 bean2 = (MyDestroyBean2) context.getBean("myDestroyBean2");

        context.registerShutdownHook();
    }
}
