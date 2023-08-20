package com.zkk.dao.admin;

import com.zkk.pojo.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AllStudentDao {
    public StringBuffer selectStudent(Connection connection,String competitionName) throws SQLException;
}
