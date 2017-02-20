package com.rupeng.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rupeng.bookstore.entity.Book;
import com.rupeng.bookstore.service.BookService;

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
        List<Book> bookList = bookService.list();
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/WEB-INF/jsp/bookList.jsp").forward(request, response);
    }

}
