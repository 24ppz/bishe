package com.zkk.servlet.admin;

import com.zkk.pojo.Competition;
import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddCompetitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String competitionName = req.getParameter("competitionName");
        String dateString = req.getParameter("date");
        Date date = Date.valueOf(dateString);
        String describe = req.getParameter("describe");
        String teacherId = req.getParameter("teacherId");
        String teacherName = req.getParameter("teacherName");

        String nameCode = "[\u4e00-\u9fa5]+";

        if (id.length() != 4) {
            req.setAttribute("idLength", "编号长度应为4位");
        } else if ("".equals(competitionName) || competitionName == null) {
            req.setAttribute("competitionNameNull", "名称不能为空！");
        } else if (date == null) {
            req.setAttribute("dateNull", "请选择日期！");
        } else if (teacherId.length() != 7) {
            req.setAttribute("teacherIdLength", "工号长度应为7位");
        } else if ("".equals(teacherName) || teacherName == null) {
            req.setAttribute("teacherNameNull", "教师不能为空！");
        } else if (!teacherName.matches(nameCode)) {
            req.setAttribute("teacherNameCode", "只能使用纯汉字");
        } else {
            ServiceImpl service = new ServiceImpl();

            boolean flag = false;
            try {
                flag = service.addCompetition(id, competitionName, date, describe, teacherId, teacherName);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            if (flag) {
                req.setAttribute("info", "添加成功");
            } else {
                req.setAttribute("info", "添加失败，检查是否已存在");
            }
            ArrayList<Competition> competition = null;
            try {
                competition = service.selectCompetition();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("competition", competition);
        }

        req.getRequestDispatcher("jsp/admin/competition.jsp").forward(req, resp);
    }
}
