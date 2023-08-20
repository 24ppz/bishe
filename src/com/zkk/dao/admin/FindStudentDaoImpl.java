package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class FindStudentDaoImpl implements FindStudentDao {
    @Override
    public StringBuffer findStudent(Connection connection, String id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        StringBuffer student = new StringBuffer();

        int year = Integer.parseInt(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        String name = null;

        if (connection != null) {
            String sql = "select * from student where id = ?";
            Object[] params = {id};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            if (resultSet != null) {
                student.append("<table>");
                student.append("<tr>");
                student.append("<th>学号</th>");
                student.append("<th>系部</th>");
                student.append("<th>年级</th>");
                student.append("<th>班级</th>");
                student.append("<th>名字</th>");
                student.append("</tr>");
                while (resultSet.next()) {
                    student.append("<tr>");
                    student.append("<td>").append(resultSet.getString(1)).append("</td>");
                    student.append("<td>").append(resultSet.getString(3)).append("</td>");
                    student.append("<td>").append(resultSet.getInt(4)).append("</td>");
                    student.append("<td>").append(resultSet.getString(5)).append("</td>");
                    student.append("<td>").append(resultSet.getString(6)).append("</td>");
                    name = resultSet.getString(6);
                    student.append("</tr>");
                }
                student.append("</table>");
                student.append("<form method=\"post\" name=\"updateStudent\" action=\"/${pageContext.request.contextPath}/student.do\">\n");
                student.append("<p>\n" +
                        "        学号：\n" +
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
                        "        年级：\n" +
                        "        <label>\n" +
                        "            <select name=\"grade\">\n" +
                        "                <option>" + (year - 4) +
                        "                </option>\n" +
                        "                <option>" + (year - 3) +
                        "                </option>\n" +
                        "                <option>" + (year - 2) +
                        "                </option>\n" +
                        "                <option>" + (year - 1) +
                        "                </option>\n" +
                        "                <option selected=\"selected\">" + year +
                        "                </option>\n" +
                        "                <option>" + (year + 1) +
                        "                </option>\n" +
                        "            </select>\n" +
                        "        </label>\n" +
                        "    </p>\n" +
                        "    <p>\n" +
                        "        <script type=\"text/javascript\">\n" +
                        "            const department = document.getElementById(\"department\");\n" +
                        "            department.onclick = function () {\n" +
                        "                const value = department.value;\n" +
                        "                switch (value) {\n" +
                        "                    case \"艺术与设计系\":\n" +
                        "                        document.getElementById(\"class\").innerHTML =\n" +
                        "                            \"<option>艺术设计1班</option>\" +\n" +
                        "                            \"<option>视觉传播设计与制作1班</option>\" +\n" +
                        "                            \"<option>动漫设计1班</option>\" +\n" +
                        "                            \"<option>游戏设计1班</option>\" +\n" +
                        "                            \"<option>人物形象设计1班</option>\" +\n" +
                        "                            \"<option>美容美体艺术1班</option>\";\n" +
                        "                        break;\n" +
                        "                    case \"英汉语言文学系\":\n" +
                        "                        document.getElementById(\"class\").innerHTML =\n" +
                        "                            \"<option>英语1班</option>\" +\n" +
                        "                            \"<option>英语2班</option>\" +\n" +
                        "                            \"<option>英语3班</option>\" +\n" +
                        "                            \"<option>汉语言文学1班</option>\" +\n" +
                        "                            \"<option>汉语言文学2班</option>\" +\n" +
                        "                            \"<option>汉语言文学3班</option>\";\n" +
                        "                        break;\n" +
                        "                    case \"工商管理系\":\n" +
                        "                        document.getElementById(\"class\").innerHTML =\n" +
                        "                            \"<option>工商管理1班</option>\" +\n" +
                        "                            \"<option>工商管理2班</option>\" +\n" +
                        "                            \"<option>工商管理3班</option>\" +\n" +
                        "                            \"<option>工商管理4班</option>\" +\n" +
                        "                            \"<option>工商管理5班</option>\" +\n" +
                        "                            \"<option>工商管理6班</option>\";\n" +
                        "                        break;\n" +
                        "                    case \"经济贸易系\":\n" +
                        "                        document.getElementById(\"class\").innerHTML =\n" +
                        "                            \"<option>国际经济与贸易1班</option>\" +\n" +
                        "                            \"<option>国际经济与贸易2班</option>\" +\n" +
                        "                            \"<option>经济学1班</option>\" +\n" +
                        "                            \"<option>经济学2班</option>\" +\n" +
                        "                            \"<option>会计1班</option>\" +\n" +
                        "                            \"<option>会计2班</option>\";\n" +
                        "                        break;\n" +
                        "                    case \"工程技术系\":\n" +
                        "                        document.getElementById(\"class\").innerHTML =\n" +
                        "                            \"<option>工业设计1班</option>\" +\n" +
                        "                            \"<option>工业设计2班</option>\" +\n" +
                        "                            \"<option>工业设计3班</option>\" +\n" +
                        "                            \"<option>电气工程及其自动化1班</option>\" +\n" +
                        "                            \"<option>电气工程及其自动化2班</option>\" +\n" +
                        "                            \"<option>电气工程及其自动化3班</option>\";\n" +
                        "                        break;\n" +
                        "                    case \"信息工程系\":\n" +
                        "                        document.getElementById(\"class\").innerHTML =\n" +
                        "                            \"<option>计算机科学与技术1班</option>\" +\n" +
                        "                            \"<option>计算机科学与技术2班</option>\" +\n" +
                        "                            \"<option>软件技术1班</option>\" +\n" +
                        "                            \"<option>软件技术2班</option>\" +\n" +
                        "                            \"<option>电子信息工程1班</option>\" +\n" +
                        "                            \"<option>电子信息工程2班</option>\";\n" +
                        "                        break;\n" +
                        "                }\n" +
                        "            }\n" +
                        "        </script>\n" +
                        "        班级：\n" +
                        "        <label>\n" +
                        "            <select id=\"class\" name=\"class\">\n" +
                        "                <option selected=\"selected\" value=\"\">--请先选择系部--</option>\n" +
                        "            </select>\n" +
                        "        </label>\n" +
                        "    </p>\n" +
                        "    <p>\n" +
                        "        姓名：\n" +
                        "        <label>\n" +
                        "            <input type=\"text\" name=\"name\" value=\"" + name + "\">\n" +
                        "        </label>\n" +
                        "    </p>\n" +
                        "    <input type=\"submit\" value=\"修改\">\n");
                student.append("</form>");
            }
        }
        BaseDao.closeResource(null, statement, resultSet);

        return student;
    }
}
