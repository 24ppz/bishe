package com.zkk.dao.student;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.LyTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LiuYanllDaoImpl implements LiuYanllDao{
    @Override
    public ArrayList<LyTable> liuYanll(Connection connection) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<LyTable> lytable = new ArrayList<LyTable>();

        if (connection != null) {
            String sql = "select * from lytable where id != ?";
            Object[] params = {"0"};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            while (resultSet.next()) {
                LyTable L = new LyTable();
                L.setId(resultSet.getInt(1));
                L.setStudentName(resultSet.getString(2));
                L.setTitle(resultSet.getString(3));
                L.setContent(resultSet.getString(4));
                L.setReply(resultSet.getString(5));
                lytable.add(L);
            }

        }
        BaseDao.closeResource(null, statement, resultSet);

        return lytable;
    }
}
