package com.rupeng.bookstore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.rupeng.bookstore.entity.Book;
import com.rupeng.bookstore.utils.JDBCUtils;
import com.rupeng.bookstore.utils.Page;

public class BookDao
{

    public void list(Page<Book> page) throws SQLException
    {
        String countSql = "select count(*) from book";
        String sql = "select * from book limit ?,?";

        ResultSet rs = null;
        ResultSet countRs = null;
        Connection conn = null;
        try
        {
            conn = JDBCUtils.getConnection();
            rs = JDBCUtils.executeQuery(conn, sql, (page.getTargetPage() - 1) * page.getSize(), page.getSize());
            List<Book> bookList = JDBCUtils.packEntityList(Book.class, rs);
            page.setItems(bookList);

            countRs = JDBCUtils.executeQuery(conn, countSql);
            countRs.next();
            int totalCount = countRs.getInt(1);
            int totalPage = (totalCount + page.getSize() - 1) / page.getSize();
            page.setTotalPage(totalPage);

        }
        finally
        {
            JDBCUtils.closeResultSetAndStatement(rs);
            JDBCUtils.closeAll(countRs);
        }
    }

    public void list(Page<Book> page, Integer categoryId) throws SQLException
    {
        String countSql = "select count(*) from book where categoryId=?";
        String sql = "select * from book where categoryId=? limit ?,?";

        ResultSet rs = null;
        ResultSet countRs = null;
        Connection conn = null;
        try
        {
            conn = JDBCUtils.getConnection();
            rs = JDBCUtils.executeQuery(conn, sql, categoryId, (page.getTargetPage() - 1) * page.getSize(),
                    page.getSize());
            List<Book> bookList = JDBCUtils.packEntityList(Book.class, rs);
            page.setItems(bookList);

            countRs = JDBCUtils.executeQuery(conn, countSql, categoryId);
            countRs.next();
            int totalCount = countRs.getInt(1);
            int totalPage = (totalCount + page.getSize() - 1) / page.getSize();
            page.setTotalPage(totalPage);

        }
        finally
        {
            JDBCUtils.closeResultSetAndStatement(rs);
            JDBCUtils.closeAll(countRs);
        }
    }

    public void list(Page<Book> page, String searchText) throws SQLException
    {
        String sql = "select * from book where name like ?  or author like ? limit ?,?";
        String countSql = "select count(*) from book where name like ? or author like ?";

        ResultSet rs = null;
        ResultSet countRs = null;
        Connection conn = null;
        try
        {
            conn = JDBCUtils.getConnection();
            rs = JDBCUtils.executeQuery(conn, sql, searchText, searchText, (page.getTargetPage() - 1) * page.getSize(),
                    page.getSize());
            List<Book> bookList = JDBCUtils.packEntityList(Book.class, rs);
            page.setItems(bookList);

            countRs = JDBCUtils.executeQuery(conn, countSql, searchText, searchText);
            countRs.next();
            int totalCount = countRs.getInt(1);
            int totalPage = (totalCount + page.getSize() - 1) / page.getSize();
            page.setTotalPage(totalPage);

        }
        finally
        {
            JDBCUtils.closeResultSetAndStatement(rs);
            JDBCUtils.closeAll(countRs);
        }
    }

}
