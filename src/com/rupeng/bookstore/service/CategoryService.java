package com.rupeng.bookstore.service;

import java.util.List;

import com.rupeng.bookstore.dao.CategoryDao;
import com.rupeng.bookstore.entity.Category;

public class CategoryService
{
    private CategoryDao categoryDao = new CategoryDao();

    public List<Category> list()
    {
        try
        {
            return categoryDao.list();
        }
        catch (Exception e)
        {
            throw new RuntimeException();
        }
    }

}
