package com.zkk.dao.admin;

import com.zkk.pojo.Competition;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FindCompetitionDao {
    public ArrayList<Competition> findCompetition(Connection connection, String id) throws SQLException;
}
