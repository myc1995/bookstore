package com.rupeng.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.rupeng.bookstore.entity.Category;
import com.rupeng.bookstore.utils.JDBCUtils;

public class CategoryDao
{

    public List<Category> list() throws SQLException
    {
        String sql = "select * from category";
        ResultSet rs = null;
        try
        {
            rs = JDBCUtils.executeQuery(sql);
            return JDBCUtils.packEntityList(Category.class, rs);
        }
        finally
        {
            JDBCUtils.closeAll(rs);
        }
    }
}
