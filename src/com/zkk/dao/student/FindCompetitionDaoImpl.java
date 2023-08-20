package com.zkk.dao.student;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Competition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindCompetitionDaoImpl implements  FindCompetitionDao {
    @Override
    public Competition findCompetition(Connection connection, String id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Competition com = new Competition();
        if (connection != null) {
            String sql = "select * from competition where id = ?";
            Object[] params = {id};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);
            while (resultSet.next()) {
                com.setCompetitionName(resultSet.getString(2));
                com.setDate(resultSet.getDate(3));
                com.setDescribe(resultSet.getString(4));
                com.setTeacherId(resultSet.getString(5));
                com.setTeacherName(resultSet.getString(6));
            }
            BaseDao.closeResource(null, statement, resultSet);
        }
        return com;
    }
}
