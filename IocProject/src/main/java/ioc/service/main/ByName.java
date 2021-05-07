package ioc.service.main;

import ioc.bean.di.byname.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ByName {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeanDiByName.xml");

        //不配置id与name
        StudentByName1 t1 = (StudentByName1) context.getBean("ioc.bean.di.byname.StudentByName1");
//        StudentByName1 t1 = (StudentByName1) context.getBean("StudentByName1");
//        StudentByName1 t1 = (StudentByName1) context.getBean(StudentByName1.class.getName());
        System.out.println(t1);
//        System.out.println(StudentByName1.class.getName());//ioc.bean.di.byname.StudentByName1

        //只配置id，id作为唯一标识
        StudentByName2 t2 = (StudentByName2) context.getBean("student2");
        System.out.println(t2);

        //只配置name，name作为唯一标识
        StudentByName3 t3 = (StudentByName3) context.getBean("student3");
        System.out.println(t3);

        //同时配置了id与name，id作为唯一标识，name作为别名
        StudentByName4 t41 = (StudentByName4) context.getBean("student4");
        System.out.println(t41);

        //使用name别名
        StudentByName4 t42 = (StudentByName4) context.getBean("student41");
        System.out.println(t42);

        //同时配置了id与name，且id与name相同
        StudentByName5 t5 = (StudentByName5) context.getBean("student5");
        System.out.println(t5);

        //没有配置id，而name属性设置了多个值，那么name的第一个值会被用作标识符，其他的值被视为别名。如果配置了id，那么name的所有值都是别名
        StudentByName6 t6 = (StudentByName6) context.getBean("student6");
        StudentByName6 t61 = (StudentByName6) context.getBean("t61");
        System.out.println(t6);
        System.out.println(t61);
    }
}
