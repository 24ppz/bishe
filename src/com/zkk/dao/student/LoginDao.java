package com.zkk.dao.student;

import com.zkk.pojo.Student;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

public interface LoginDao {
    public Student getLoginStudent(Connection connection, String id, String password, HttpSession session) throws SQLException;
}
