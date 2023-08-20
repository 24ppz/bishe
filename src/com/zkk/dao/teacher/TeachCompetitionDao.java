package com.zkk.dao.teacher;

import java.sql.Connection;
import java.sql.SQLException;

public interface TeachCompetitionDao {
    public boolean teachCompetition(Connection connection, String teacherId, String competitionId, String competitionName, String date, String describe) throws SQLException;
}
