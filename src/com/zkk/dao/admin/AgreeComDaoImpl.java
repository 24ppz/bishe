package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Agree;
import com.zkk.pojo.Competition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgreeComDaoImpl implements AgreeComDao{
    @Override
    public boolean agreeComp(Connection connection, String uid, String cid) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String comname = null;

        int rows = 0;

        if (connection != null) {
            String sql = "delete from agreecom where uid = ?";
            Object[] params = {uid};

            BaseDao.execute(connection, statement, sql, params);
        }
        BaseDao.closeResource(null, statement, null);

        if (connection != null) {
            String sql = "select * from competition where id = ?";
            Object[] params = {cid};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);
            while (resultSet.next()){
                comname = resultSet.getString(2);
            }
        }
        BaseDao.closeResource(null, statement, null);

        if(connection != null){
            String sql = "update student set " +
                    "competition_name = ? " +
                    "where id = ?";
            Object[] params = {comname,uid};

            rows = BaseDao.execute(connection, statement, sql, params);

        }
        BaseDao.closeResource(null, statement, null);

        return rows!=0;
    }
}
