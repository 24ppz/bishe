package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTeacherDaoImpl implements DeleteTeacherDao {
    @Override
    public boolean deleteTeacher(Connection connection, String id) throws SQLException {
        PreparedStatement statement = null;
        int rows1 = 0;
        int rows2 = 0;

        if (connection != null) {
            String sql = "delete from teacher where id = ?";
            Object[] params = {id};

            rows1 = BaseDao.execute(connection, statement, sql, params);
        }
        BaseDao.closeResource(null, statement, null);

        if (connection != null) {
            String sql = "delete from competition where teacher_id = ?";
            Object[] params = {id};

            rows2 = BaseDao.execute(connection, statement, sql, params);
        }
        BaseDao.closeResource(null, statement, null);

        return (rows1 != 0 && rows2 != 0);
    }
}
