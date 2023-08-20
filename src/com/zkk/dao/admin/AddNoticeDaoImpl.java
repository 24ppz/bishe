package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNoticeDaoImpl implements AddNoticeDao{
    @Override
    public boolean addNotice(Connection connection, String filename, String url) throws SQLException {
        PreparedStatement statement = null;
        int rows = 0;

        if (connection != null) {
            String sql = "insert into notice " +
                    "(name, url) " +
                    "values (?, ?)";
            Object[] params = {filename, url};

            rows = BaseDao.execute(connection, statement, sql, params);
        }

        BaseDao.closeResource(null, statement, null);

        return rows != 0;
    }
}
