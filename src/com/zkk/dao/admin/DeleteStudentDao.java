package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface DeleteStudentDao {
    public boolean deleteStudent(Connection connection, String id) throws SQLException;
}
