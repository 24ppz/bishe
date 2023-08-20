package com.zkk.dao.student;

import com.zkk.pojo.LyTable;

import java.sql.Connection;
import java.sql.SQLException;

public interface LiuYaneDao {
    public boolean liuyanDao(Connection connection, String studentName, String title, String content) throws SQLException;
}
