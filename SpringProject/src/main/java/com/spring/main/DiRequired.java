package com.spring.main;

import com.spring.bean.di.useAnno.required.StudentRequired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于注解 @Required
 */
public class DiRequired {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanRequired.xml");
        StudentRequired studentRequired = (StudentRequired) context.getBean("studentRequired");
        System.out.println(studentRequired.getName());
        System.out.println(studentRequired.getAge());
    }
}
