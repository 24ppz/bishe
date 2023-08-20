package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudentDaoImpl implements DeleteStudentDao {
    @Override
    public boolean deleteStudent(Connection connection, String id) throws SQLException {
        PreparedStatement statement = null;
        int rows = 0;

        if (connection != null) {
            String sql = "delete from student where id = ?";
            Object[] params = {id};

            rows = BaseDao.execute(connection, statement, sql, params);
        }
        BaseDao.closeResource(null, statement, null);

        return rows != 0;
    }
}
