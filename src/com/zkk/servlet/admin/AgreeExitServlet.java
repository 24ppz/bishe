package com.zkk.servlet.admin;

import com.zkk.pojo.Agree;
import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AgreeExitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");

        ServiceImpl service = new ServiceImpl();
        Agree A = null;
        try {
            A = service.findAgree(uid);
            String cid = A.getCid();
            service.agreeExit(uid,cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("jsp/admin/baoming.jsp").forward(req,resp);

    }
}
