package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface AddStudentDao {
    public boolean hasStudent(Connection connection, String id) throws SQLException;

    public boolean addStudent(Connection connection, String id, String department, int grade, String className, String studentName) throws SQLException;
}
