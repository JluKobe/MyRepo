package com.spring.main;

import com.spring.bean.lifecycle.PostProcessBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PostProcessMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeanPostProcess.xml");
        PostProcessBean bean = (PostProcessBean) context.getBean("postProcessBean");
        bean.getMessage();
        context.registerShutdownHook();
    }
}
