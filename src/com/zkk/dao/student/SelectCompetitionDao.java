package com.zkk.dao.student;

import com.zkk.pojo.Competition;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SelectCompetitionDao {
    public ArrayList<Competition> selectCompetition(Connection connection) throws SQLException;
}
