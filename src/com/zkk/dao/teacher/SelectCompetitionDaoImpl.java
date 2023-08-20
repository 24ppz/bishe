package com.zkk.dao.teacher;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Competition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectCompetitionDaoImpl implements SelectCompetitionDao {
    @Override
    public Competition select(Connection connection, String teacherId) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Competition competition = new Competition();

        if (connection != null) {
            String sql = "select * from competition where teacher_id = ?";
            Object[] params = {teacherId};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            while (resultSet.next()) {
                competition.setId(resultSet.getString(1));
                competition.setCompetitionName(resultSet.getString(2));
                competition.setDate(resultSet.getDate(3));
                competition.setDescribe(resultSet.getString(4));
                competition.setTeacherId(resultSet.getString(5));
                competition.setTeacherName(resultSet.getString(6));
            }
        }
        BaseDao.closeResource(null, statement, resultSet);
        return competition;
    }
}
