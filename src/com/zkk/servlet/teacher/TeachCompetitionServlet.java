package com.zkk.servlet.teacher;

import com.zkk.service.teacher.Service;
import com.zkk.service.teacher.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class TeachCompetitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacherId = (String) req.getSession().getAttribute("id");
        String competitionId = req.getParameter("competitionId");
        String competitionName = req.getParameter("competitionName");
        String date = req.getParameter("date");
        String describe = req.getParameter("describe");

        Service service = new ServiceImpl();
        try {
            if (service.teachCompetition(teacherId, competitionId, competitionName, date, describe)) {
                req.setAttribute("success", "修改成功！");
            } else {
                req.setAttribute("error", "修改失败！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getRequestDispatcher("jsp/teacher/teachCompetition.jsp").forward(req, resp);
    }
}
