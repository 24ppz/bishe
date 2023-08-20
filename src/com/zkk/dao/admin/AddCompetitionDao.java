package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public interface AddCompetitionDao {
    public boolean hasCompetition(Connection connection, String id) throws SQLException;

    public boolean addCompetition(Connection connection, String id, String competitionName, Date date, String describe, String teacherId, String teacherName) throws SQLException;
}
