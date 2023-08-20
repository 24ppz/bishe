package com.zkk.servlet.admin;

import com.zkk.pojo.LyTable;
import com.zkk.service.student.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class LiuyanaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceImpl service = new ServiceImpl();
        ArrayList<LyTable> liuyan = null;

        liuyan = service.liuyanLL();

        req.setAttribute("liuyan", liuyan);
        req.getRequestDispatcher("jsp/admin/liuyan.jsp").forward(req, resp);
    }
}
