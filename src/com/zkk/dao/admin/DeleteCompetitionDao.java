package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface DeleteCompetitionDao {
    public boolean deleteCompetition(Connection connection, String id) throws SQLException;
}
