package com.zkk.dao.student;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinCompetitionDaoImpl implements JoinCompetitionDao {
    @Override
    public String joinCompetition(Connection connection, String studentId, String competitionId) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int rows = 0;

        String competitionName = null;

        if (connection != null) {
            String sql = "select * from competition where id = ?";
            Object[] params = {competitionId};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            while (resultSet.next()) {
                try {
                    competitionName = resultSet.getString(2);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            BaseDao.closeResource(null, statement, resultSet);
        }

        if (connection != null && competitionName != null) {
            String sql = "update student set competition_name = ? where id = ?";
            Object[] params = {competitionName, studentId};

            rows = BaseDao.execute(connection, statement, sql, params);
            BaseDao.closeResource(null, statement, resultSet);
        }

        if (rows == 0) {
            return null;
        } else {
            return competitionName;
        }
    }

    @Override
    public boolean hasCompetition(Connection connection, String id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            String sql = "select * from competition where id = ?";
            Object[] params = {id};

            try {
                resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        BaseDao.closeResource(null, statement, resultSet);

        if (resultSet != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isJoin(Connection connection, String id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            String sql = "select * from student where id = ?";
            Object[] params = {id};

            try {
                resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            String competitionName = null;
            while (resultSet.next()) {
                competitionName = resultSet.getString(7);
            }
            BaseDao.closeResource(null, statement, resultSet);
            if (competitionName == null) {
                return false;
            } else {
                return true;
            }
        } else {
            BaseDao.closeResource(null, statement, resultSet);
            return true;
        }
    }
}
