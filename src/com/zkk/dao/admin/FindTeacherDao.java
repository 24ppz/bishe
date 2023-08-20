package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface FindTeacherDao {
    public StringBuffer findTeacher(Connection connection, String id) throws SQLException;
}
