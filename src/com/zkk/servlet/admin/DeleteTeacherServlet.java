package com.zkk.servlet.admin;

import com.zkk.pojo.Teacher;
import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteTeacherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        boolean flag = false;

        ServiceImpl service = new ServiceImpl();

        try {
            flag = service.deleteTeacher(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ArrayList<Teacher> teacher = null;
        try {
            teacher = service.selectTeacher();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("teacher", teacher);
        req.getRequestDispatcher("jsp/admin/teacher.jsp").forward(req, resp);
    }
}
