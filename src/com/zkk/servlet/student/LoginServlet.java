package com.zkk.servlet.student;

import com.zkk.pojo.Student;
import com.zkk.service.student.ServiceImpl;
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
        Student student = service.login(id, password, req.getSession());

        if (student != null) {
            req.getSession().setAttribute(Constants.STUDENT_SESSION, student);
            resp.sendRedirect("jsp/student/main.jsp");
        } else {
            req.setAttribute("error", "用户名或密码不正确");
            req.getRequestDispatcher("jsp/student/login.jsp").forward(req, resp);
        }
    }
}
