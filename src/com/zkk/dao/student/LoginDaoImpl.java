package com.zkk.dao.student;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Student;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    @Override
    public Student getLoginStudent(Connection connection, String id, String password, HttpSession session) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Student student = null;

        if (connection != null) {
            String sql = "select * from student where id = ? and password = ?";
            Object[] params = {id, password};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            if (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getString("id"));
                student.setPassword(resultSet.getString("password"));
                student.setDepartment(resultSet.getString("department"));
                student.setGrade(resultSet.getInt("grade"));
                student.setClassName(resultSet.getString("class_name"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setCompetitionName(resultSet.getString("competition_name"));
            }
            BaseDao.closeResource(null, statement, resultSet);
        }

        return student;
    }
}
