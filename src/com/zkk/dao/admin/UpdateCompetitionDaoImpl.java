package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCompetitionDaoImpl implements UpdateCompetitionDao {
    @Override
    public boolean updateCompetition(Connection connection, String id, String competitionName, Date date, String describe, String teacherId, String teacherName) throws SQLException {
        PreparedStatement statement = null;
        int rows = 0;

        if (connection != null) {
            String sql = "update competition set " +
                    "competition_name = ?, date = ?, competition_describe = ?, teacher_id = ?, teacher_name = ? " +
                    "where id = ?";
            Object[] params = {competitionName, date, describe, teacherId, teacherName, id};

            rows = BaseDao.execute(connection, statement, sql, params);
        }

        BaseDao.closeResource(null, statement, null);

        return rows != 0;
    }
}
