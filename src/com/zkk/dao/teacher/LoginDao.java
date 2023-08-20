package com.zkk.dao.teacher;

import com.zkk.pojo.Teacher;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

public interface LoginDao {
    public Teacher getLoginTeacher(Connection connection, String id, String password, HttpSession session) throws SQLException;
}
