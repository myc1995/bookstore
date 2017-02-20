package com.rupeng.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rupeng.bookstore.entity.Book;
import com.rupeng.bookstore.service.BookService;
import com.rupeng.bookstore.utils.Page;

@WebServlet("/book")
public class BookServlet extends HttpServlet
{
    private BookService bookService = new BookService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getParameter("action");
        if ("list".equals(action))
        {
            processList(request, response);
        }
    }

    private void processList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int size = 6;
        int targetPage = 1;
        try
        {
            targetPage = Integer.parseInt(request.getParameter("targetPage"));
        }
        catch (Exception e)
        {
        }
        Integer categoryId = null;
        try
        {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));
        }
        catch (Exception e)
        {
        }
        Page<Book> page = new Page<Book>(size, targetPage);
        if (categoryId != null)
        {
            bookService.list(page, categoryId);
        }
        else
        {
            bookService.list(page);
        }

        request.setAttribute("page", page);
        request.getRequestDispatcher("/WEB-INF/jsp/bookList.jsp").forward(request, response);
    }

}
