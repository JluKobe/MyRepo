package com.spring.main;

import com.spring.bean.di.byname.TextEditorByName;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * byName，与xml中属性相匹配，即与id相匹配
 */
public class DiByNameMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeanDiByName.xml");
        TextEditorByName textEditorByName = (TextEditorByName) context.getBean("textEditorByName");
        textEditorByName.spellCheck();
    }
}
