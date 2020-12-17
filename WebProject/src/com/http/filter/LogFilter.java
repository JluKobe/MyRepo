package com.http.filter;

import javax.servlet.*;
import java.io.IOException;

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        // 获取初始化参数
        String site = config.getInitParameter("Site");
        String fileName = config.getFilterName();

        // 输出初始化参数
        System.out.println("网站名称: " + site);

        System.out.println(fileName);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 输出站点名称
        System.out.println("站点网址：http://www.runoob.com");

        // 把请求传回过滤链
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
