package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface DeleteTeacherDao {
    public boolean deleteTeacher(Connection connection, String id) throws SQLException;
}
