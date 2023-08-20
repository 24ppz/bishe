package com.zkk.dao.teacher;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Teacher;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    @Override
    public Teacher getLoginTeacher(Connection connection, String id, String password, HttpSession session) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Teacher teacher = null;

        if (connection != null) {
            String sql = "select * from teacher where id = ? and password = ?";
            Object[] params = {id, password};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            if (resultSet.next()) {
                teacher = new Teacher();
                teacher.setId(resultSet.getString("id"));
                teacher.setPassword(resultSet.getString("password"));
                teacher.setDepartment(resultSet.getString("department"));
                teacher.setTeacherName(resultSet.getString("teacher_name"));
                teacher.setCompetitionName(resultSet.getString("competition_name"));
            }
            BaseDao.closeResource(null, statement, resultSet);
        }

        return teacher;
    }
}
