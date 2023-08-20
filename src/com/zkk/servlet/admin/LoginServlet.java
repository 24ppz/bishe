package com.zkk.servlet.admin;

import com.zkk.pojo.Admin;
import com.zkk.service.admin.ServiceImpl;
import com.zkk.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        ServiceImpl service = new ServiceImpl();
        Admin admin = service.login(id, password);

        if (admin != null) {
            req.getSession().setAttribute(Constants.ADMIN_SESSION, admin);
            resp.sendRedirect("jsp/admin/main.jsp");
        } else {
            req.setAttribute("error", "用户名或密码不正确");
            req.getRequestDispatcher("jsp/admin/login.jsp").forward(req, resp);
        }
    }
}
