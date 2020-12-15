package com.http.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是FilterDemo2，客户端向Servlet发送的请求被我拦截到了");
        //对请求放行，进入Servlet
        chain.doFilter(request, response);
        System.out.println("我是FilterDemo2，Servlet向客户端发送的响应被我拦截到了");
    }

    @Override
    public void destroy() {

    }
}
