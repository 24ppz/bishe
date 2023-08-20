package com.zkk.dao.student;

import com.zkk.pojo.Competition;

import java.sql.Connection;
import java.sql.SQLException;

public interface FindCompetitionDao {
    public Competition findCompetition(Connection connection, String id) throws SQLException;
}
