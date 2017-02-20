package com.rupeng.bookstore.service;

import java.util.List;

import com.rupeng.bookstore.dao.BookDao;
import com.rupeng.bookstore.entity.Book;

public class BookService
{
    private BookDao bookDao = new BookDao();

    public List<Book> list()
    {
        try
        {
            return bookDao.list();
        }
        catch (Exception e)
        {
            throw new RuntimeException();
        }
    }
}
