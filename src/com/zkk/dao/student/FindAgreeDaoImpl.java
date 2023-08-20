package com.zkk.dao.student;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Agree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindAgreeDaoImpl implements FindAgreeDao{
    @Override
    public Agree findAgree(Connection connection, String uid) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Agree A = new Agree();

        if (connection != null) {
            String sql = "select * from agreecom where uid = ?";
            Object[] params = {uid};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            while (resultSet.next()) {
                A.setUid(resultSet.getString(1));
                A.setCid(resultSet.getString(2));
                A.setCom(resultSet.getString(3));
                A.setExit(resultSet.getString(4));
            }
        }
        BaseDao.closeResource(null, statement, resultSet);
        return A;
    }
}
