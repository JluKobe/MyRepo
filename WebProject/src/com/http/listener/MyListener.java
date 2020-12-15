package com.http.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listener init method");
        System.out.println("ServletContextListener.contextInitialized方法被调用");
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("listener destroyed method");
        System.out.println("ServletContextListener.contextDestroyed方法被调用");
    }
}