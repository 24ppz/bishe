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

public class SelectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String competition = req.getParameter("competition");

        ArrayList<Student> stu = null;
        if (id != null) {
            ServiceImpl service = new ServiceImpl();
            try {
                stu = service.select(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (competition != null) {
            ServiceImpl service = new ServiceImpl();
            try {
                stu = service.select(competition);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        req.setAttribute("student", stu);

        req.getRequestDispatcher("jsp/admin/student.jsp").forward(req, resp);
    }
}
