package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllStudentDaoImpl implements AllStudentDao {
    @Override
    public StringBuffer selectStudent(Connection connection,String competitionName) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        StringBuffer student = new StringBuffer();

        if (connection != null) {
            String sql = "select * from student where competition_name = ?";
            Object[] params = {competitionName};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            student.append("<table>");
            student.append("<tr>");
            student.append("<th>学生学号</th>");
            student.append("<th>系部</th>");
            student.append("<th>年级</th>");
            student.append("<th>班级</th>");
            student.append("<th>姓名</th>");
            student.append("<th>参加竞赛</th>");
            student.append("</tr>");

            while (resultSet.next()) {
                student.append("<tr>");
                student.append("<td>").append(resultSet.getString(1)).append("</td>");
                student.append("<td>").append(resultSet.getString(3)).append("</td>");
                student.append("<td>").append(resultSet.getString(4)).append("</td>");
                student.append("<td>").append(resultSet.getString(5)).append("</td>");
                student.append("<td>").append(resultSet.getString(6)).append("</td>");
                student.append("<td>").append(resultSet.getString(7)).append("</td>");
                student.append("</tr>");
                if (resultSet.getString(7) == null) {
                    student.append("<td></td>");
                } else {
                    student.append("<td>").append(resultSet.getString(7)).append("</td>");
                }
                student.append("</tr>");
            }
            student.append("</table>");
        }
        BaseDao.closeResource(null, statement, resultSet);

        return student;
    }
}
