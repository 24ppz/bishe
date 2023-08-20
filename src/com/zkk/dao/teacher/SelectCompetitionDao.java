package com.zkk.dao.teacher;

import com.zkk.pojo.Competition;

import java.sql.Connection;
import java.sql.SQLException;

public interface SelectCompetitionDao {
    public Competition select(Connection connection, String teacherId) throws SQLException;
}
