package com.zkk.servlet.admin;

import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String department = req.getParameter("department");
        String gradeString = req.getParameter("grade");
        int grade = Integer.parseInt(gradeString);
        String className = req.getParameter("class");
        String studentName = req.getParameter("name");

        String nameCode = "[\u4e00-\u9fa5]+";

        if (id.length() <= 7) {
            req.setAttribute("idLength", "id长度应大于7位");
        } else if ("".equals(studentName) || studentName == null) {
            req.setAttribute("nameNull", "名字不能为空！");
        } else if (!studentName.matches(nameCode)) {
            req.setAttribute("nameCode", "只能使用纯汉字");
        } else if (className == null || "".equals(className)) {
            req.setAttribute("classNameNull", "请选择班级！");
        } else {
            ServiceImpl service = new ServiceImpl();

            boolean flag = false;
            try {
                flag = service.updateStudent(id, department, grade, className, studentName);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            if (flag) {
                req.setAttribute("success", "修改成功");
            } else {
                req.setAttribute("error", "修改失败，请检查学号是否正确");
            }
        }
        req.getRequestDispatcher("jsp/admin/updateStudent.jsp").forward(req, resp);
    }
}
