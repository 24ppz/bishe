package com.zkk.servlet.admin;

import com.zkk.pojo.Competition;
import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompetitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceImpl service = new ServiceImpl();
        ArrayList<Competition> competition = null;
        try {
            competition = service.selectCompetition();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        req.setAttribute("competition", competition);
        req.getRequestDispatcher("jsp/admin/competition.jsp").forward(req, resp);
    }
}
