package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaoMingDaoImpl implements BaoMingDao{
    @Override
    public StringBuffer baoMing(Connection connection) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        StringBuffer stu = new StringBuffer();

        if (connection != null) {
            String sql = "select * from student where competition_name is not ?";
            Object[] params = {"Null"};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            stu.append("<table>");
            stu.append("<tr>");
            stu.append("<th>学号</th>");
            stu.append("<th>密码</th>");
            stu.append("<th>系部</th>");
            stu.append("<th>年级</th>");
            stu.append("<th>班级</th>");
            stu.append("<th>姓名</th>");
            stu.append("<th>比赛</th>");
            stu.append("</tr>");

            while (resultSet.next()) {
                stu.append("<tr>");
                stu.append("<td>").append(resultSet.getString(1)).append("</td>");
                stu.append("<td>").append(resultSet.getString(2)).append("</td>");
                stu.append("<td>").append(resultSet.getString(3)).append("</td>");
                stu.append("<td>").append(resultSet.getString(4)).append("</td>");
                stu.append("<td>").append(resultSet.getString(5)).append("</td>");
                stu.append("<td>").append(resultSet.getString(6)).append("</td>");
                if (resultSet.getString(7) == null) {
                    stu.append("<td></td>");
                } else {
                    stu.append("<td>").append(resultSet.getString(7)).append("</td>");
                }
                stu.append("</tr>");
            }

            stu.append("</table>");
        }
        BaseDao.closeResource(null, statement, resultSet);

        return stu;
    }
}
