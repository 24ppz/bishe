package com.zkk.dao.admin;

import com.zkk.pojo.Agree;
import com.zkk.pojo.Student;
import com.zkk.pojo.Tab;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SelectBaomingDao {
    public ArrayList<Agree> selectBaoll(Connection connection) throws SQLException;
}
