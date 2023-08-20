package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface AgreeExitDao {
    public boolean agreeExit(Connection connection, String uid, String cid) throws SQLException;
}
