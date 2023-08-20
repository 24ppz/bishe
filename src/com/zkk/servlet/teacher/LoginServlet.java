package com.zkk.servlet.teacher;

import com.zkk.pojo.Teacher;
import com.zkk.service.teacher.ServiceImpl;
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
        Teacher teacher = service.login(id, password, req.getSession());

        if (teacher != null) {
            req.getSession().setAttribute(Constants.TEACHER_SESSION, teacher);
            resp.sendRedirect("jsp/teacher/main.jsp");
        } else {
            req.setAttribute("error", "用户名或密码不正确");
            req.getRequestDispatcher("jsp/teacher/login.jsp").forward(req, resp);
        }
    }
}
