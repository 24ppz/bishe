package com.zkk.dao.student;

import java.sql.Connection;
import java.sql.SQLException;

public interface AgreeComaddDao {
    public boolean agreeadd(Connection connection, String uid, String cid) throws SQLException;
}
