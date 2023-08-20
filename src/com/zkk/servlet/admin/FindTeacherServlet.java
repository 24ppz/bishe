package com.zkk.servlet.admin;

import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FindTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id.length() >= 7) {
            ServiceImpl service = new ServiceImpl();

            StringBuffer teacher = null;
            try {
                teacher = service.findTeacher(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("teacher", teacher);
        } else {
            req.setAttribute("error", "工号必须大于6位");
        }
        req.getRequestDispatcher("jsp/admin/updateTeacher.jsp").forward(req, resp);
    }
}
