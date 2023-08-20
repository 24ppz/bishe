package com.zkk.dao.student;

import com.mysql.cj.Session;
import com.zkk.pojo.LyTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface LiuYanllDao {
    public ArrayList<LyTable> liuYanll(Connection connection) throws SQLException;
}
