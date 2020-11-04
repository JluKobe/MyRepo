package com.spring.main;

import com.spring.bean.lifecycle.MyInitBean;
import com.spring.bean.lifecycle.MyInitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInitMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansInit.xml");

        MyInitializingBean bean1 = (MyInitializingBean) context.getBean("myInitializingBean");
        MyInitBean bean2 = (MyInitBean) context.getBean("myInitBean");
    }
}
