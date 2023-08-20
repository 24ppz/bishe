package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTeacherDaoImpl implements UpdateTeacherDao {
    @Override
    public boolean updateTeacher(Connection connection, String id, String department, String teacherName, String competitionName) throws SQLException {
        PreparedStatement statement = null;
        int rows = 0;

        if (connection != null) {
            String sql = "update teacher set " +
                    "department = ?, teacher_name = ?, competition_name = ? " +
                    "where id = ?";
            Object[] params = {department, teacherName, competitionName, id};

            rows = BaseDao.execute(connection, statement, sql, params);
        }

        BaseDao.closeResource(null, statement, null);

        return rows != 0;
    }
}
