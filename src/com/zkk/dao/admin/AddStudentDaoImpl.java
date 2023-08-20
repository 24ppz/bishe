package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AddStudentDaoImpl implements AddStudentDao {
    @Override
    public boolean hasStudent(Connection connection, String id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            String sql = "select * from student where id = ?";
            Object[] params = {id};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);
        }
        BaseDao.closeResource(null, statement, resultSet);
        if (resultSet != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addStudent(Connection connection, String id, String department, int grade, String className, String studentName) throws SQLException {
        PreparedStatement statement = null;
        int rows = 0;

        if (connection != null) {
            String sql = "insert into student " +
                    "(id, password, department, grade, class_name, student_name) " +
                    "values (?, ?, ?, ?, ?, ?)";
            Object[] params = {id, "123456", department, grade, className, studentName};

            rows = BaseDao.execute(connection, statement, sql, params);
        }

        BaseDao.closeResource(null, statement, null);

        return rows != 0;
    }
}
