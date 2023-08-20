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

public class FindCompetitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id.length() == 4) {
            ServiceImpl service = new ServiceImpl();

            ArrayList<Competition> competition = null;
            try {
                competition = service.findCompetition(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("competition", competition);
        } else {
            req.setAttribute("error", "编号必须为4位");
        }
        req.getRequestDispatcher("jsp/admin/updateCompetition.jsp").forward(req, resp);
    }
}
