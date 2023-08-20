package com.zkk.dao.admin;

import com.zkk.pojo.Agree;
import com.zkk.pojo.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SelectDao {
    public ArrayList<Student> select(Connection connection,String id) throws SQLException;
}
