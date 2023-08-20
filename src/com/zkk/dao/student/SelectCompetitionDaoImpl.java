package com.zkk.dao.student;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Competition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectCompetitionDaoImpl implements SelectCompetitionDao {
    @Override
    public ArrayList<Competition> selectCompetition(Connection connection) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<Competition> competition = new ArrayList<Competition>();

        if (connection != null) {
            String sql = "select * from competition where id != ?";
            Object[] params = {"0"};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            while (resultSet.next()) {
                Competition C = new Competition();
                C.setId(resultSet.getString(1));
                C.setCompetitionName(resultSet.getString(2));
                C.setDate(resultSet.getDate(3));
                C.setDescribe(resultSet.getString(4));
                C.setTeacherId(resultSet.getString(5));
                C.setTeacherName(resultSet.getString(6));
                competition.add(C);
            }

        }
        BaseDao.closeResource(null, statement, resultSet);

        return competition;
    }
}
