package com.spring.main;

import com.spring.bean.di.useAnno.qualifier.Profile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 创建多个具有相同类型的 bean 时，使用@Qualifier注解，指定某一个真正bean来消除混乱
 */
public class DiQualifierMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanDiQualifier.xml");
        Profile profile = (Profile) context.getBean("profile");
        profile.printAge();
        profile.printName();
    }
}
