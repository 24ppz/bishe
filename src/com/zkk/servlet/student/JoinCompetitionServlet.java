package com.zkk.servlet.student;

import com.zkk.pojo.Competition;
import com.zkk.service.student.Service;
import com.zkk.service.student.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;

public class JoinCompetitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = (String) req.getSession().getAttribute("id");
        String competitionId = req.getParameter("competitionId");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//当前系统时间
        Service service = new ServiceImpl();

        boolean flag = false;
        try {
            //数据库时间
            Competition com = service.findCompetition(competitionId);
            Date da = com.getDate();
            if(da.after(date)){
                flag = service.AgreeComadd(studentId, competitionId);
            }else{
                req.setAttribute("afterda", "当前时间节点不在报名范围内！");
                req.getRequestDispatcher("jsp/student/competition.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (flag) {
            req.setAttribute("success", "等待审核！");
        } else {
            req.setAttribute("error", "报名失败！请仔细检查");
        }
        req.getRequestDispatcher("jsp/student/competition.jsp").forward(req, resp);
    }
}