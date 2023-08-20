package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface UpdateStudentDao {
    public boolean updateStudentDao(Connection connection, String id, String department, int grade, String className, String studentName) throws SQLException;
}
