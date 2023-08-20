package com.zkk.dao.student;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePwdDaoImpl implements ChangePwdDao {
    @Override
    public boolean changePassword(Connection connection, String id, String newPassword, String oldPassword) throws SQLException {
        PreparedStatement statement = null;

        if (connection != null) {
            String sql = "update student set password = ? where id = ? and password = ?";
            Object[] params = {newPassword, id, oldPassword};

            int rows = BaseDao.execute(connection, statement, sql, params);

            BaseDao.closeResource(connection, statement, null);

            if (rows != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
