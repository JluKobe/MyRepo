package com.http.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo1的init方法被调用");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是FilterDemo1，客户端向Servlet发送的请求被我拦截到了");
        chain.doFilter(request, response);
        System.out.println("我是FilterDemo1，Servlet向客户端发送的响应被我拦截到了");
    }

    @Override
    public void destroy() {
        System.out.println("FilterDemo1的destroy方法被调用");
    }
}
