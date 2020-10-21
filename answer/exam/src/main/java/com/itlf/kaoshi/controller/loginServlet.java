package com.itlf.kaoshi.controller;

import com.itlf.kaoshi.pojo.User;
import com.itlf.kaoshi.service.loginServic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Author LiuFeng
 * @Date 2020/10/10 20:14
 */
@WebServlet("/loginServlet")
@SuppressWarnings("all")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("user");
            System.out.println(username);
            String password = request.getParameter("password");
            User user = new User(username, password);
            System.out.println(user);
            //调用业务层
            loginServic loginServic = new loginServic();
            boolean flag = loginServic.login(user);
            System.out.println(flag);

            if (flag) {
                request.getSession().setAttribute("user", user);

                response.sendRedirect(  "index.jsp");
            } else {

                request.setAttribute("flag",flag);
                //转发
                /* response.sendRedirect("login.jsp");*/
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("服务器异常");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
