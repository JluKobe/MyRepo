package com.spring.main;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception{
            //读取mybatis-config.xml文件
            InputStream resourceAsStream = Resources.getResourceAsStream("BeanDiByName.xml");
            //初始化mybatis,创建SqlSessionFactory类的实例
            SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(resourceAsStream);
            //创建session实例
            SqlSession session = sqlSessionFactory.openSession();
            /*
             * 接下来在这里做很多事情,到目前为止,目的已经达到得到了SqlSession对象.通过调用SqlSession里面的方法,
             * 可以测试MyBatis和Dao层接口方法之间的正确性,当然也可以做别的很多事情,在这里就不列举了
             */
            //插入数据
//            User user = new User();
//            user.setC_password("123");
//            user.setC_username("123");
//            user.setC_salt("123");
            //第一个参数为方法的完全限定名:位置信息+映射文件当中的id
//            session.insert("com.cn.dao.UserMapping.insertUserInformation", user);
            //提交事务
            session.commit();
            //关闭session
            session.close();
    }
}


//    public static void main(String[] args) {
//        try {
//            //读取mybatis-config.xml文件
//            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
//            //初始化mybatis,创建SqlSessionFactory类的实例
//            SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(resourceAsStream);
//            //创建session实例
//            SqlSession session = sqlSessionFactory.openSession();
//            /*
//             * 接下来在这里做很多事情,到目前为止,目的已经达到得到了SqlSession对象.通过调用SqlSession里面的方法,
//             * 可以测试MyBatis和Dao层接口方法之间的正确性,当然也可以做别的很多事情,在这里就不列举了
//             */
//            //插入数据
//            User user = new User();
//            user.setC_password("123");
//            user.setC_username("123");
//            user.setC_salt("123");
//            //第一个参数为方法的完全限定名:位置信息+映射文件当中的id
//            session.insert("com.cn.dao.UserMapping.insertUserInformation", user);
//            //提交事务
//            session.commit();
//            //关闭session
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }