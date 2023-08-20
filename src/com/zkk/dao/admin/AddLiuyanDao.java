package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface AddLiuyanDao {
    public boolean addLiuyanDao(Connection connection, String reply, String id) throws SQLException;
}
