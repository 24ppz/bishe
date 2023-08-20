package com.zkk.dao.teacher;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeachCompetitionDaoImpl implements TeachCompetitionDao {
    @Override
    public boolean teachCompetition(Connection connection, String teacherId, String competitionId, String competitionName, String date, String describe) throws SQLException {
        PreparedStatement statement = null;
        int row1 = 0;
        int row2 = 0;
        Date sqlDate = Date.valueOf(date);

        if (connection != null) {
            String sql = "update competition set competition_name = ?, date = ?, competition_describe = ? where id = ?";
            Object[] params = {competitionName, sqlDate, describe, competitionId};

            row1 = BaseDao.execute(connection, statement, sql, params);
        }
        if (connection != null) {
            String sql = "update teacher set competition_name = ? where id = ?";
            Object[] params = {competitionName, teacherId};

            row2 = BaseDao.execute(connection, statement, sql, params);
        }
        BaseDao.closeResource(null, statement, null);

        if (row1 == 0 || row2 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
