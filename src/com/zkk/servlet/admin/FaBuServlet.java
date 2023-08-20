package com.zkk.servlet.admin;

import com.zkk.service.admin.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;

@MultipartConfig
public class FaBuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //设置请求编码格式
        req.setCharacterEncoding("UTF-8");
        //通过getPart(name)方法获取Part对象，（name代表的是也米娜中file文件域的属性值）
        Part part = req.getPart("file");
        //通过Part对象，获取上传文件的名
        String filename = part.getSubmittedFileName();
        //获取上传文件需要存放的路径（得到项目的真实路径）
        String realPath = req.getServletContext().getRealPath("/");
        boolean flag = false;

        try{
            //将文件上传到指定位置
            part.write(realPath+filename);
            ServiceImpl service = new ServiceImpl();

            flag = service.addNotice(filename,filename);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(flag){
            req.setAttribute("info","发布成功");
        }else {
            req.setAttribute("info","发布失败!");
        }
        req.getRequestDispatcher("jsp/admin/fabu.jsp").forward(req,resp);
    }
}
