package com.zkk.dao.student;

import com.zkk.dao.BaseDao;
import com.zkk.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LiuYaneDaoImpl implements LiuYaneDao{
    @Override
    public boolean liuyanDao(Connection connection, String studentName, String title, String content) throws SQLException{
        PreparedStatement statement = null;
        int rows = 0;

        if (connection != null) {
            String sql = "insert into lytable " +
                    "(studentName ,title ,content)" +
                    "values (?, ?, ?)";
            Object[] params = {studentName, title, content};

            rows = BaseDao.execute(connection, statement, sql, params);
        }

        BaseDao.closeResource(null, statement, null);

        return rows != 0;
    }
}
