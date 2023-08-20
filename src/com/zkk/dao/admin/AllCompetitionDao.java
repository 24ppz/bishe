package com.zkk.dao.admin;

import com.zkk.pojo.Competition;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AllCompetitionDao {
    public ArrayList<Competition> selectCompetition(Connection connection) throws SQLException;
}
