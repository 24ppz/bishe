package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudentDaoImpl implements UpdateStudentDao {
    @Override
    public boolean updateStudentDao(Connection connection, String id, String department, int grade, String className, String studentName) throws SQLException {
        PreparedStatement statement = null;
        int rows = 0;

        if (connection != null) {
            String sql = "update student set " +
                    "department = ?, grade = ?, class_name = ?, student_name = ? " +
                    "where id = ?";
            Object[] params = {department, grade, className, studentName, id};

            rows = BaseDao.execute(connection, statement, sql, params);
        }

        BaseDao.closeResource(null, statement, null);

        return rows != 0;
    }
}
