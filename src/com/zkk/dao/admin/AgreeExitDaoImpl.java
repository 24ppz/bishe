package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgreeExitDaoImpl implements AgreeExitDao{
    @Override
    public boolean agreeExit(Connection connection, String uid, String cid) throws SQLException {
        PreparedStatement statement = null;

        int rows = 0;

        if (connection != null) {
            String sql = "delete from agreecom where uid = ?";
            Object[] params = {uid};

            BaseDao.execute(connection, statement, sql, params);
        }
        BaseDao.closeResource(null, statement, null);

        if(connection != null){
            String sql = "update student set " +
                    "competition_name = null " +
                    "where id = ?";
            Object[] params = {uid};

            rows = BaseDao.execute(connection, statement, sql, params);

        }
        BaseDao.closeResource(null, statement, null);

        return rows!=0;
    }
}
