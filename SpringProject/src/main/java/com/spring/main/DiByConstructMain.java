package com.spring.main;

import com.spring.bean.di.byConstruct.TextEditorByConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * byConstruct，由构造函数自动匹配
 */
public class DiByConstructMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanDiByConstruct.xml");
        TextEditorByConstruct textEditorByConstruct = (TextEditorByConstruct) context.getBean("textEditorByConstruct");
        textEditorByConstruct.spellCheck();
    }
}
