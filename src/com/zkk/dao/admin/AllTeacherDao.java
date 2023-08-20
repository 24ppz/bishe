package com.zkk.dao.admin;

import com.zkk.pojo.Teacher;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AllTeacherDao {
    public ArrayList<Teacher> selectTeacher(Connection connection) throws SQLException;
}
