package com.spring.scope.main;

import com.spring.scope.bean.User;
import com.spring.scope.bean.User2;
import com.spring.scope.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanDiScope.xml");
        User user1 = (User) context.getBean("scopeuser");
        User user2 = (User) context.getBean("scopeuser");

        System.out.println(user1.getName());
        System.out.println(user1.getAge());

        System.out.println(user2.getName());
        System.out.println(user2.getAge());


        user1.setName("zzzzz");

        System.out.println(user1.getName());
        System.out.println(user2.getName());

        ApplicationContext context1 = new AnnotationConfigApplicationContext(BeanConfig.class);
        User2 u1 = context1.getBean(User2.class);
        User2 u2 = context1.getBean(User2.class);

        System.out.println(u1.getName());
        System.out.println(u1.getAge());

        System.out.println(u2.getName());
        System.out.println(u2.getAge());

        u1.setName("zzzz");
        System.out.println(u1.getName());
        System.out.println(u2.getName());
    }
}
