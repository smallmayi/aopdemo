package com.aop.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "test", urlPatterns = "/test/*")
public class FilConfig implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----------------------->过滤器被创建");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //application域
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取aplication域
        ServletContext application = request.getServletContext();
        Object num = application.getAttribute("num");
        if (num == null){
            application.setAttribute("num",1);
        }else {
            int temp = (Integer)num;
            temp++;
            application.setAttribute("num",temp);
        }
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {
        System.out.println("----------------------->过滤器被销毁");
    }
}
