package com.zkk.servlet.teacher;

import com.zkk.pojo.Competition;
import com.zkk.service.teacher.Service;
import com.zkk.service.teacher.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SelectCompetitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId = (String) req.getSession().getAttribute("id");

        Service service = new ServiceImpl();

        Competition competition = null;

        try {
            competition = service.selectCompetition(teacherId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (competition != null) {
            req.setAttribute("id", competition.getId());
            req.setAttribute("name", competition.getCompetitionName());
            req.setAttribute("date", competition.getDate());
            req.setAttribute("describe", competition.getDescribe());
        } else {
            req.setAttribute("error", "查询失败！");
        }
        req.getRequestDispatcher("jsp/teacher/teachCompetition.jsp").forward(req, resp);
    }
}
