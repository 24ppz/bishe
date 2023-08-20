package com.zkk.servlet.admin;

import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String department = req.getParameter("department");
        String teacherName = req.getParameter("teacherName");
        String competitionName = req.getParameter("competitionName");

        String nameCode = "[\u4e00-\u9fa5]+";

        if (id.length() < 7 ) {
            req.setAttribute("idLength", "工号长度应大于等于7位");
        } else if ("".equals(teacherName) || teacherName == null) {
            req.setAttribute("nameNull", "名字不能为空！");
        } else if (!teacherName.matches(nameCode)) {
            req.setAttribute("nameCode", "只能使用纯汉字");
        } else if ("".equals(competitionName) || competitionName == null) {
            req.setAttribute("competitionNull", "比赛不能为空！");
        } else {
            ServiceImpl service = new ServiceImpl();

            boolean flag = false;
            try {
                flag = service.addTeacher(id, department, teacherName, competitionName);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (flag) {
                req.setAttribute("info", "添加成功");
            } else {
                req.setAttribute("info", "添加失败，检查是否已存在");
            }
        }
        req.getRequestDispatcher("jsp/admin/addTeacher.jsp").forward(req, resp);
    }
}
