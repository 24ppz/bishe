package com.zkk.servlet.admin;

import com.zkk.pojo.Agree;
import com.zkk.pojo.Competition;
import com.zkk.pojo.Student;
import com.zkk.pojo.Tab;
import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaoMingServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceImpl service = new ServiceImpl();
        ArrayList<Agree> baoming = new ArrayList<Agree>();
        ArrayList<Tab> T = new ArrayList<Tab>();
        try {
            baoming = service.selectBaoming();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (int i = 0; i < baoming.size(); i++){
            Tab t = new Tab();
            String uid = baoming.get(i).getUid();
            String com = baoming.get(i).getCom();
            String exi = baoming.get(i).getExit();
            ArrayList<Student> s = null;
            try {
                s = service.select(uid);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            t.setUid(uid);
            t.setGrade(s.get(0).getGrade());
            t.setUname(s.get(0).getStudentName());
            t.setCom(com);
            t.setExi(exi);


            String cid = baoming.get(i).getCid();
            ArrayList<Competition> ss = null;
            try {
                ss = service.findCompetition(cid);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            t.setCid(cid);
            t.setCname(ss.get(0).getCompetitionName());
            t.setJzdate(ss.get(0).getDate());
            T.add(t);
        }


        req.setAttribute("T", T);
        req.getRequestDispatcher("jsp/admin/baoming.jsp").forward(req, resp);
    }
}
