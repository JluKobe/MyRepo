package com.spring.main;

import com.spring.bean.di.bytype.TextEditorByType;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * byType，与xml中的类型相匹配，即与class匹配
 */
public class DiByTypeMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeanDiByType.xml");
        TextEditorByType textEditorByType = (TextEditorByType) context.getBean("textEditorByType");
        textEditorByType.spellCheck();
    }
}
