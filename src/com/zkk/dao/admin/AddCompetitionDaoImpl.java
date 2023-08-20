package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.*;

public class AddCompetitionDaoImpl implements AddCompetitionDao {
    @Override
    public boolean hasCompetition(Connection connection, String id) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            String sql = "select * from competition where id = ?";
            Object[] params = {id};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);
        }
        BaseDao.closeResource(null, statement, resultSet);
        if (resultSet == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean addCompetition(Connection connection, String id, String competitionName, Date date, String describe, String teacherId, String teacherName) throws SQLException {
        PreparedStatement statement = null;
        int rows = 0;

        if (connection != null) {
            String sql = "insert into competition " +
                    "(id, competition_name, date, competition_describe, teacher_id, teacher_name) " +
                    "values (?, ?, ?, ?, ?, ?)";
            Object[] params = {id, competitionName, date, describe, teacherId, teacherName};

            rows = BaseDao.execute(connection, statement, sql, params);
        }

        BaseDao.closeResource(null, statement, null);

        return rows != 0;
    }
}
