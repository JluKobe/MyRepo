package com;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet implements Servlet {

    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse response) throws ServletException, IOException {
        String servletName = servletConfig.getServletName();
        //网页响应类型，浏览器将其渲染为HTML格式
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head></head>" + "<body> Hello from " + servletName + "</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "My Servlet";
    }

    @Override
    public void destroy() {

    }
}
