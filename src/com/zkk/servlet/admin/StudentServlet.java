package com.zkk.servlet.admin;

import com.zkk.pojo.Student;
import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceImpl service = new ServiceImpl();
        ArrayList<Student> student = null;
        try {
            student = service.allStudent();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        req.setAttribute("student", student);
        req.getRequestDispatcher("jsp/admin/student.jsp").forward(req, resp);
    }
}
