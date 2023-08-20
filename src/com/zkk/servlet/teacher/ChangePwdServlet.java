package com.zkk.servlet.teacher;

import com.zkk.service.teacher.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangePwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldPassword = req.getParameter("teacherOldPassword");
        String newPassword = req.getParameter("teacherNewPassword");
        String confirmPassword = req.getParameter("teacherConfirmPassword");
        HttpSession session = req.getSession(false);

        String code = "[a-zA-Z0-9]+";

        boolean i = newPassword.matches(code);

        if (newPassword.length() < 6 || newPassword.length() > 16 || !i) {
            req.setAttribute("confirm", "密码在6到16位以及只使用英文或数字");
            req.getRequestDispatcher("jsp/teacher/changePwd.jsp").forward(req, resp);
        } else {
            if (newPassword.equals(confirmPassword)) {
                ServiceImpl teacherService = new ServiceImpl();
                boolean flag = teacherService.changePassword(session, oldPassword, newPassword);

                if (flag) {
                    req.setAttribute("success", "成功修改");
                    req.getRequestDispatcher("jsp/teacher/changePwd.jsp").forward(req, resp);
                } else {
                    req.setAttribute("error", "修改失败，请确认旧密码");
                    req.getRequestDispatcher("jsp/teacher/changePwd.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("confirm", "修改失败，请确认新密码和确认密码是否相同");
                req.getRequestDispatcher("jsp/teacher/changePwd.jsp").forward(req, resp);
            }
        }
    }
}
