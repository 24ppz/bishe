package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface BaoMingDao {
    public StringBuffer baoMing(Connection connection) throws SQLException;
}
