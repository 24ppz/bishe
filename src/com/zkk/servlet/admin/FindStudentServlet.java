package com.zkk.servlet.admin;

import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FindStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id.length() >= 8) {
            ServiceImpl service = new ServiceImpl();

            StringBuffer student = null;
            try {
                student = service.findStudent(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("student", student);
        } else {
            req.setAttribute("error", "学号必须大于8位");
        }
        req.getRequestDispatcher("jsp/admin/updateStudent.jsp").forward(req, resp);
    }
}
