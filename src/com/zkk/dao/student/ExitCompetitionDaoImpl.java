package com.zkk.dao.student;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExitCompetitionDaoImpl implements ExitCompetitionDao {
    @Override
    public boolean exit(Connection connection, String uid, String cid) throws SQLException {
        PreparedStatement statement = null;
        int rows = 0;

        if (connection != null) {
            String sql = "insert into agreecom " +
                    "(uid, cid, exi) " +
                    "values (?, ?, ?)";
            Object[] params = {uid, cid, "0"};

            rows = BaseDao.execute(connection, statement, sql, params);
        }

        BaseDao.closeResource(null, statement, null);

        return rows!=0;
    }
}
