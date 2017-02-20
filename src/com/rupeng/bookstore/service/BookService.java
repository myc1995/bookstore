package com.rupeng.bookstore.service;

import com.rupeng.bookstore.dao.BookDao;
import com.rupeng.bookstore.entity.Book;
import com.rupeng.bookstore.utils.Page;

public class BookService
{
    private BookDao bookDao = new BookDao();

    public void list(Page<Book> page)
    {
        try
        {
            bookDao.list(page);
        }
        catch (Exception e)
        {
            throw new RuntimeException();
        }
    }

    public void list(Page<Book> page, Integer categoryId)
    {
        try
        {
            bookDao.list(page, categoryId);
        }
        catch (Exception e)
        {
            throw new RuntimeException();
        }
    }

}
