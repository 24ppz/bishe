package com.zkk.dao.teacher;

import java.sql.Connection;
import java.sql.SQLException;

public interface ChangePwdDao {
    public boolean changePassword(Connection connection, String id, String newPassword, String oldPassword) throws SQLException;
}
