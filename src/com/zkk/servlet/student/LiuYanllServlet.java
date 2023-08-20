package com.zkk.servlet.student;

import com.zkk.pojo.LyTable;
import com.zkk.pojo.Student;
import com.zkk.service.student.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LiuYanllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceImpl service = new ServiceImpl();
        ArrayList<LyTable> liuyan = null;
        liuyan = service.liuyanLL();

        req.setAttribute("liuyan", liuyan);
        req.getRequestDispatcher("jsp/student/liuyan.jsp").forward(req, resp);
    }
}
