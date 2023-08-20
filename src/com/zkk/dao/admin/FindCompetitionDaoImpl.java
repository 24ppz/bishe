package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Competition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindCompetitionDaoImpl implements FindCompetitionDao {
    @Override
    public ArrayList<Competition> findCompetition(Connection connection, String id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<Competition> competition = new ArrayList<Competition>();

        if (connection != null) {
            String sql = "select * from competition where id = ?";
            Object[] params = {id};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            if (resultSet != null) {

                while (resultSet.next()) {
                    Competition c = new Competition();
                    c.setCompetitionName(resultSet.getString(2));
                    c.setDate(resultSet.getDate(3));
                    c.setDescribe(resultSet.getString(4));
                    c.setTeacherId(resultSet.getString(5));
                    c.setTeacherName(resultSet.getString(6));
                    competition.add(c);
                }

            }
        }
        BaseDao.closeResource(null, statement, resultSet);

        return competition;
    }
}
