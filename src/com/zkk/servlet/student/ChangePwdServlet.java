package com.zkk.servlet.student;

import com.zkk.service.student.ServiceImpl;

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
        String oldPwd = req.getParameter("oldPwd");
        String newPwd = req.getParameter("newPwd");
        String confirmPwd = req.getParameter("confirmPwd");
        HttpSession session = req.getSession(false);

        String code = "[a-zA-Z0-9]+";

        boolean isInCode = newPwd.matches(code);

        if (newPwd.length() < 6 || newPwd.length() > 16 || !isInCode) {
            req.setAttribute("confirm", "密码6到16位且只用英文或数字");
            req.getRequestDispatcher("jsp/student/changePwd.jsp").forward(req, resp);
        } else {
            if (newPwd.equals(confirmPwd)) {
                ServiceImpl service = new ServiceImpl();
                boolean flag = service.changePwd(session, oldPwd, newPwd);

                if (flag) {
                    req.setAttribute("success", "成功修改");
                    req.getRequestDispatcher("jsp/student/changePwd.jsp").forward(req, resp);
                } else {
                    req.setAttribute("error", "修改失败，请确认旧密码");
                    req.getRequestDispatcher("jsp/student/changePwd.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("confirm", "修改失败，请确认新密码和确认密码是否相同");
                req.getRequestDispatcher("jsp/student/changePwd.jsp").forward(req, resp);
            }
        }
    }
}
