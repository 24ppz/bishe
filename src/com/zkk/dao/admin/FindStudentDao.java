package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface FindStudentDao {
    public StringBuffer findStudent(Connection connection, String id) throws SQLException;
}
