package com.zkk.dao.student;

import java.sql.Connection;
import java.sql.SQLException;

public interface JoinCompetitionDao {
    public String joinCompetition(Connection connection, String studentId, String competitionId) throws SQLException;

    public boolean hasCompetition(Connection connection, String id);

    public boolean isJoin(Connection connection, String id) throws SQLException;
}
