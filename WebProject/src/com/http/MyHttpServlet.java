package com.http;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class MyHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpServlet");

        response.setContentType("text/html");
        response.setCharacterEncoding("GBK");
        PrintWriter out=response.getWriter();
        out.print("<HTML>");
        out.println("<HEAD><TITLE>Servlet实例</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("servlet实例");
        out.println(this.getClass());
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
        response.getWriter().append("Served at: ").append(request.getContextPath());

        String servletName = this.getServletName();
        ServletContext servletContext = this.getServletContext();
        ServletConfig servletConfig = this.getServletConfig();
        Enumeration<String> stringEnumeration = this.getInitParameterNames();

        int port = request.getServerPort();
        StringBuffer url = request.getRequestURL();

        Enumeration<String> enumeration = request.getParameterNames();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println("test");
    }
}
