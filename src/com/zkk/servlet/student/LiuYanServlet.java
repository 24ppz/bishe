package com.zkk.servlet.student;

import com.zkk.service.student.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LiuYanServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentName = (String) req.getSession().getAttribute("studentName");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        if ("".equals(title) || title == null) {
            req.setAttribute("titleNull", "标题不能为空！");
        } else if ("".equals(content) || content == null) {
            req.setAttribute("contentNull", "内容不能为空！");
        } else {

            ServiceImpl service = new ServiceImpl();
            boolean flag = false;
            try {
                flag = service.liuyanE(studentName, title, content);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (flag) {
                req.setAttribute("error", "留言成功");
            } else {
                req.setAttribute("success", "留言失败！");
            }
        }
        req.getRequestDispatcher("jsp/student/liuyan.jsp").forward(req, resp);
    }

}
