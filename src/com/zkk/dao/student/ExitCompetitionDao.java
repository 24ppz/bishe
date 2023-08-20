package com.zkk.dao.student;

import java.sql.Connection;
import java.sql.SQLException;

public interface ExitCompetitionDao {
    public boolean exit(Connection connection, String id, String cid) throws SQLException;
}
