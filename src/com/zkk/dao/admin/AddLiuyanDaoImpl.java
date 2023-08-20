package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddLiuyanDaoImpl implements AddLiuyanDao{
    @Override
    public boolean addLiuyanDao(Connection connection,String reply, String id) throws SQLException {
        PreparedStatement statement = null;
        int rows = 0;

        if (connection != null) {
            String sql = "update lytable set " +
                    "reply = ?" +
                    "where id = ?";
            Object[] params = {reply, id};

            rows = BaseDao.execute(connection, statement, sql, params);
        }

        BaseDao.closeResource(null, statement, null);

        return rows != 0;
    };
}
