package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Competition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteCompetitionDaoImpl implements DeleteCompetitionDao {
    @Override
    public boolean deleteCompetition(Connection connection, String id) throws SQLException {
        PreparedStatement statement = null;
        int rows1 = 0;
        ResultSet resultSet = null;
        String competitionName = null;
        Competition C = new Competition();

        if (connection != null) {
            String sql = "select * from competition where id = ?";
            Object[] params = {id};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);
            while (resultSet.next()) {
                C.setCompetitionName(resultSet.getString(2));
            }
        }
        BaseDao.closeResource(null, statement, null);

        competitionName = C.getCompetitionName();

        if (connection != null && competitionName != null) {
            String sql = "update teacher set competition_name = null where competition_name = ?";
            Object[] params = {competitionName};

            BaseDao.execute(connection, statement, sql, params);
        }
        BaseDao.closeResource(null, statement, null);

        if (connection != null && competitionName != null) {
            String sql = "update student set competition_name = null where competition_name = ?";
            Object[] params = {competitionName};

            BaseDao.execute(connection, statement, sql, params);
        }
        BaseDao.closeResource(null, statement, null);

        if (connection != null) {
            String sql = "delete from competition where id = ?";
            Object[] params = {id};

            rows1 = BaseDao.execute(connection, statement, sql, params);
        }
        BaseDao.closeResource(null, statement, null);

        return rows1 != 0;
    }
}
