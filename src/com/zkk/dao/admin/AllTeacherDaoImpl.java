package com.zkk.dao.admin;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Competition;
import com.zkk.pojo.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AllTeacherDaoImpl implements AllTeacherDao {
    @Override
    public ArrayList<Teacher> selectTeacher(Connection connection) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        ArrayList<Teacher> teacher =new ArrayList<Teacher>();

        if (connection != null) {
            String sql = "select * from teacher where id != ?";
            Object[] params = {"0"};

            resultSet = BaseDao.execute(connection, statement, resultSet, sql, params);

            while (resultSet.next()) {
                Teacher T = new Teacher();
                T.setId(resultSet.getString(1));
                T.setPassword(resultSet.getString(2));
                T.setDepartment(resultSet.getString(3));
                T.setTeacherName(resultSet.getString(4));
                T.setCompetitionName(resultSet.getString(5));
                teacher.add(T);
            }

        }
        BaseDao.closeResource(null, statement, resultSet);

        return teacher;
    }
}
