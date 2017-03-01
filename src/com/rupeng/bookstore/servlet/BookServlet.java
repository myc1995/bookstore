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
import com.rupeng.bookstore.utils.PageAjaxResult;
import com.rupeng.bookstore.utils.Utils;

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
        else if ("detail".equals(action))
        {
            processDetail(request, response);
        }
        else if ("managerList".equals(action))
        {
            processManagerList(request, response);
        }
        else if ("managerListJson".equals(action))
        {
            processManagerListJson(request, response);
        }
        else if ("managerAdd".equals(action))
        {
            processManagerAdd(request, response);
        }
    }

    private void processManagerAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/manager/bookAdd.jsp").forward(request, response);
    }

    private void processManagerListJson(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("im here");
        int page = 1;
        int rows = 10;
        String searchText = request.getParameter("searchText");
        try
        {
            page = Integer.parseInt(request.getParameter("page"));
            rows = Integer.parseInt(request.getParameter("rows"));
        }
        catch (Exception e)
        {
        }
        PageAjaxResult pageAjaxResult = new PageAjaxResult(rows, page);
        if (Utils.isEmpty(searchText))
        {
            bookService.list(pageAjaxResult);
        }
        else
        {
            bookService.list(pageAjaxResult, "%" + searchText + "%");
        }
        Utils.sendAjaxResponse(response, pageAjaxResult);
    }

    private void processManagerList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/manager/bookList.jsp").forward(request, response);
    }

    private void processDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int bookId = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/WEB-INF/jsp/bookDetail.jsp").forward(request, response);
    }

    private void processList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String searchText = request.getParameter("searchText");
        System.out.println(searchText);
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

        if (!Utils.isEmpty(searchText))
        {
            bookService.list(page, "%" + searchText + "%");
        }
        else if (categoryId != null)
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
