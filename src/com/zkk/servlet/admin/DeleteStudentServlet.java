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

public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        boolean flag = false;

        ServiceImpl service = new ServiceImpl();

        try {
            flag = service.deleteStudent(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        ArrayList<Student> student = null;
//        try {
//            student = service.selectStudent();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        req.setAttribute("student", student);

//        if (flag) {
//            req.setAttribute("success", "删除成功");
//        } else {
//            req.setAttribute("error", "删除失败，请认真核对学号");
//        }
        req.getRequestDispatcher("jsp/admin/student.jsp").forward(req, resp);
    }
}
