package com.zkk.dao.admin;

import java.sql.Connection;
import java.sql.SQLException;

public interface AgreeComDao {
    public boolean agreeComp(Connection connection,String uid,String cid) throws SQLException;
}
