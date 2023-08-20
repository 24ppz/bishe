package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Competition;
import com.zkk.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllStuDaoImpl implements AllStuDao{
    public ArrayList<Student> allStu(Connection connection) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<Student> student = new ArrayList<Student>();

        if (connection != null) {
            String sql = "select * from student where id != ?";
            Object[] params = {"0"};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            while (resultSet.next()) {
                Student s = new Student();
                s.setId(resultSet.getString(1));
                s.setPassword(resultSet.getString(2));
                s.setDepartment(resultSet.getString(3));
                s.setGrade(resultSet.getInt(4));
                s.setClassName(resultSet.getString(5));
                s.setStudentName(resultSet.getString(6));
                s.setCompetitionName(resultSet.getString(7));
                student.add(s);
            }

        }
        BaseDao.closeResource(null, statement, resultSet);

        return student;
    }

}
