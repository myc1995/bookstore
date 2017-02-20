package com.rupeng.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.rupeng.bookstore.entity.Book;
import com.rupeng.bookstore.utils.JDBCUtils;

public class BookDao
{

    public List<Book> list() throws SQLException
    {
        String sql = "select * from book";
        ResultSet rs = null;
        try
        {
            rs = JDBCUtils.executeQuery(sql);
            List<Book> bookList = JDBCUtils.packEntityList(Book.class, rs);
            return bookList;
        }
        finally
        {
            JDBCUtils.closeAll(rs);
        }
    }

}
