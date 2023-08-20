package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public interface UpdateCompetitionDao {
    public boolean updateCompetition(Connection connection, String id, String competitionName, Date date, String describe, String teacherId, String teacherName) throws SQLException;
}
