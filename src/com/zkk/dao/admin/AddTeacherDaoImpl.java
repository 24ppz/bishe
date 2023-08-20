package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddTeacherDaoImpl implements AddTeacherDao {
    @Override
    public boolean hasTeacher(Connection connection, String id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            String sql = "select * from teacher where id = ?";
            Object[] params = {id};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);
        }
        BaseDao.closeResource(null, statement, resultSet);

        if (resultSet == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean addTeacher(Connection connection, String id, String department, String teacherName, String competitionName) throws SQLException {
        PreparedStatement statement = null;
        int rows = 0;

        if (connection != null) {
            String sql = "insert into teacher " +
                    "(id, password, department, teacher_name, competition_name) " +
                    "values (?, ?, ?, ?, ?)";
            Object[] params = {id, "123456", department, teacherName, competitionName};

            rows = BaseDao.execute(connection, statement, sql, params);
        }

        BaseDao.closeResource(null, statement, null);

        return rows != 0;
    }
}
