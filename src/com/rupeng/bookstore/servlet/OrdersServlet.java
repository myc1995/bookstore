package com.rupeng.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rupeng.bookstore.entity.Address;
import com.rupeng.bookstore.entity.Cart;
import com.rupeng.bookstore.entity.User;
import com.rupeng.bookstore.service.AddressService;
import com.rupeng.bookstore.utils.Utils;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet
{
    private AddressService addressService = new AddressService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getParameter("action");

        if ("create".equals(action))
        {
            processCreate(request, response);

        }

    }

    private void processCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null || Utils.isEmpty(cart.getCartItemList()))
        {
            request.setAttribute("message", "购物车中空的");
            request.getRequestDispatcher("/WEB-INF/jsp/cartList.jsp").forward(request, response);
            return;
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user == null)
        {
            request.setAttribute("message", "需要先登录");
            request.getRequestDispatcher("/WEB-INF/jsp/userLogin.jsp").forward(request, response);
            return;
        }
        String[] bookIdStrs = request.getParameterValues("bookIds");// 拿到所有bookIds的值
        String[] countStrs = request.getParameterValues("counts");
        int[] bookIds = new int[bookIdStrs.length];
        int[] counts = new int[bookIdStrs.length];

        for (int i = 0; i < bookIds.length; i++)
        {
            bookIds[i] = Integer.parseInt(bookIdStrs[i]);

            int count = 0;
            try
            {
                count = Integer.parseInt(countStrs[i]);
            }
            catch (Exception e)
            {
                request.setAttribute("message", "请输入正确的购买数量");
                request.getRequestDispatcher("/WEB-INF/jsp/cartList.jsp").forward(request, response);
                return;
            }
            if (count < 1)
            {
                request.setAttribute("message", "购买数量不能小于1");
                request.getRequestDispatcher("/WEB-INF/jsp/cartList.jsp").forward(request, response);
                return;
            }
            counts[i] = count;
        }
        for (int i = 0; i < bookIds.length; i++)
        {
            cart.updateItem(bookIds[i], counts[i]);
        }
        List<Address> addressList = addressService.list(user.getId());
        request.setAttribute("addressList", addressList);
        request.getRequestDispatcher("/WEB-INF/jsp/ordersCreate.jsp").forward(request, response);
    }
}
