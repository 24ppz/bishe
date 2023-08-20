package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Agree;
import com.zkk.pojo.Student;
import com.zkk.pojo.Tab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectBaomingDaoImpl implements SelectBaomingDao {
    @Override
    public ArrayList<Agree> selectBaoll(Connection connection) throws SQLException {

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<Agree> agr = new ArrayList<Agree>();

        if (connection != null) {
            String sql = "select * from agreecom where uid != ?";
            Object[] params = {"0"};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            while (resultSet.next()) {
                Agree A = new Agree();
                A.setUid(resultSet.getString(1));
                A.setCid(resultSet.getString(2));
                A.setCom(resultSet.getString(3));
                A.setExit(resultSet.getString(4));
                agr.add(A);
            }
        }
        BaseDao.closeResource(null, statement, resultSet);
        return agr;
    }
}
