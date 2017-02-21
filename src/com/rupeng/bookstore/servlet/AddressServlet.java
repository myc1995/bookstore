package com.rupeng.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rupeng.bookstore.entity.Address;
import com.rupeng.bookstore.service.AddressService;

@WebServlet("/address")
public class AddressServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private AddressService adderssService = new AddressService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getParameter("action");
        System.out.println(action);
        if ("list".equals(action))
        {
            processList(request, response);
        }
    }

    private void processList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println(userId + "hhhhhhhhhhh");
        List<Address> addressList = adderssService.findAddressById(userId);
        request.setAttribute("addressList", addressList);
        request.getRequestDispatcher("WEB-INF/jsp/addressList.jsp").forward(request, response);
    }

}
