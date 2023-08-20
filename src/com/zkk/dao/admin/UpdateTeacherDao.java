package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface UpdateTeacherDao {
    public boolean updateTeacher(Connection connection, String id, String department, String teacherName, String competitionName) throws SQLException;
}
