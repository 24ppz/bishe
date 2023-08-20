package com.zkk.servlet.admin;

import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LiuyanReplyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String reply = req.getParameter("content");

        ServiceImpl service = new ServiceImpl();

        boolean flag=false;
        try {
            flag = service.addLiuyanDao(reply,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(flag){req.setAttribute("success","回复成功！");}else{
            req.setAttribute("error", "回复失败！");

        }

        req.getRequestDispatcher("jsp/admin/liuyan.jsp").forward(req, resp);
    }
}
