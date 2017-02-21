package com.rupeng.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.rupeng.bookstore.entity.Address;
import com.rupeng.bookstore.utils.JDBCUtils;

public class AddressDao
{

    public List<Address> list(int userId) throws SQLException
    {
        String sql = "select * from address where userId = ?";
        ResultSet rs = null;
        try
        {
            rs = JDBCUtils.executeQuery(sql, userId);
            return JDBCUtils.packEntityList(Address.class, rs);
        }
        finally
        {
            JDBCUtils.closeAll(rs);
        }
    }

}
