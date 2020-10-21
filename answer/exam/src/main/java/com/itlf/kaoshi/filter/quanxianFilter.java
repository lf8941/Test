package com.itlf.kaoshi.filter;

import com.itlf.kaoshi.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author LiuFeng
 * @Date 2020/10/10 23:53
 */
public class quanxianFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取user内容
        User username = (User) request.getSession().getAttribute("user");
        //判断是否为空,以判断是否给权限往下执行
        if(username!=null){
            filterChain.doFilter(request,response);
        } else{
            response.getWriter().println("<a href=\"login.jsp\">对不起,请重新登录</a>");
        }
    }

    @Override
    public void destroy() {

    }
}
