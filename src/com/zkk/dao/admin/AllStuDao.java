package com.zkk.dao.admin;

import com.zkk.pojo.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AllStuDao {
    public ArrayList<Student> allStu(Connection connection) throws SQLException;
}
