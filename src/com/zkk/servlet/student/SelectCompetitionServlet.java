package com.zkk.servlet.student;

import com.zkk.pojo.Competition;
import com.zkk.service.student.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectCompetitionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceImpl service = new ServiceImpl();
        String ucompetitionName = (String)req.getSession().getAttribute("competitionName");
        ArrayList<Competition> competition = null;

        competition = service.selectCompetition();

        req.setAttribute("competition", competition);
        req.setAttribute("ucompetitionName", ucompetitionName);
        req.getRequestDispatcher("jsp/student/competition.jsp").forward(req, resp);
    }
}
