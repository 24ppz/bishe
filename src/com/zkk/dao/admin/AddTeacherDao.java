package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface AddTeacherDao {
    public boolean hasTeacher(Connection connection, String id) throws SQLException;

    public boolean addTeacher(Connection connection, String id, String department, String teacherName, String competitionName) throws SQLException;
}
