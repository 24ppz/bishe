package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface AddNoticeDao {
    public boolean addNotice(Connection connection, String filename,String realPath) throws SQLException;
}
