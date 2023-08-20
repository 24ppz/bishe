package com.zkk.servlet.student;

import com.zkk.service.student.Service;
import com.zkk.service.student.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ExitCompetitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = (String) req.getSession().getAttribute("id");
        String competitionId = req.getParameter("competitionId");

        Service service = new ServiceImpl();
        boolean flag = false;
        try {
            flag = service.AgreeExit(studentId,competitionId);
            req.getSession().setAttribute("competitionName", null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (flag) {
            req.setAttribute("success", "等待审核！");
        } else {
            req.setAttribute("error", "退赛失败！请仔细检查");
        }
        req.getRequestDispatcher("jsp/student/competition.jsp").forward(req, resp);
    }

}
