package com.zkk.dao.student;

import com.zkk.pojo.Agree;

import java.sql.Connection;
import java.sql.SQLException;

public interface FindAgreeDao {
    public Agree findAgree(Connection connection, String uid) throws SQLException;
}
