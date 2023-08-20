package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindTeacherDaoImpl implements FindTeacherDao {
    @Override
    public StringBuffer findTeacher(Connection connection, String id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        StringBuffer teacher = new StringBuffer();
        String name = null;

        if (connection != null) {
            String sql = "select * from teacher where id = ?";
            Object[] params = {id};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            if (resultSet != null) {
                teacher.append("<table>");
                teacher.append("<tr>");
                teacher.append("<th>工号</th>");
                teacher.append("<th>系部</th>");
                teacher.append("<th>教师</th>");
                teacher.append("<th>比赛</th>");
                teacher.append("</tr>");
                while (resultSet.next()) {
                    teacher.append("<tr>");
                    teacher.append("<td>").append(resultSet.getString(1)).append("</td>");
                    teacher.append("<td>").append(resultSet.getString(3)).append("</td>");
                    teacher.append("<td>").append(resultSet.getString(4)).append("</td>");
                    name = resultSet.getString(4);
                    teacher.append("<td>").append(resultSet.getString(5)).append("</td>");
                    teacher.append("</tr>");
                }
                teacher.append("</table>");
                teacher.append("<form method=\"post\" name=\"updateTeacher\" action=\"/SchoolCompetition_war/updateTeacher.do\">\n" +
                        "    <p>\n" +
                        "        工号：\n" +
                        "        <label>\n" +
                        "            <input type=\"number\" name=\"id\" value=\"" + id + "\">\n" +
                        "        </label>\n" +
                        "    </p>\n" +
                        "    <p>\n" +
                        "        系部：\n" +
                        "        <label>\n" +
                        "            <select id=\"department\" name=\"department\">\n" +
                        "                <option value=\"艺术与设计系\" selected=\"selected\">艺术与设计系</option>\n" +
                        "                <option value=\"英汉语言文学系\">英汉语言文学系</option>\n" +
                        "                <option value=\"工商管理系\">工商管理系</option>\n" +
                        "                <option value=\"经济贸易系\">经济贸易系</option>\n" +
                        "                <option value=\"工程技术系\">工程技术系</option>\n" +
                        "                <option value=\"信息工程系\">信息工程系</option>\n" +
                        "            </select>\n" +
                        "        </label>\n" +
                        "    </p>\n" +
                        "    <p>\n" +
                        "        姓名：\n" +
                        "        <label>\n" +
                        "            <input type=\"text\" name=\"teacherName\" value=\"" + name + "\">\n" +
                        "        </label>\n" +
                        "    </p>\n" +
                        "    <p>\n" +
                        "        比赛：\n" +
                        "        <label>\n" +
                        "            <input type=\"text\" name=\"competitionName\">\n" +
                        "        </label>\n" +
                        "    </p>\n" +
                        "    <input type=\"submit\" value=\"添加\">\n" +
                        "</form>");
            }
        }
        BaseDao.closeResource(null, statement, resultSet);

        return teacher;
    }
}
