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

public class DeleteCompetitionServlet extends HttpServlet {
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
            flag = service.deleteCompetition(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (flag) {
            req.setAttribute("info", "删除成功");
        } else {
            req.setAttribute("info", "删除失败，请认真核对编号");
        }

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
