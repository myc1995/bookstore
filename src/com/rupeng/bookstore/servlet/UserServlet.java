package com.rupeng.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rupeng.bookstore.entity.User;
import com.rupeng.bookstore.service.UserService;
import com.rupeng.bookstore.utils.Utils;

@WebServlet("/user")
public class UserServlet extends HttpServlet
{
    private UserService userService = new UserService();
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getParameter("action");
        if ("register".equals(action))
        {
            processRegister(request, response);
        }
        else if ("registerSubmit".equals(action))
        {
            prcessRegisterSubmit(request, response);
        }
        else if ("login".equals(action))
        {
            processLogin(response, request);
        }
        else if ("loginSubmit".equals(action))
        {
            processLoginSubmit(response, request);
        }
        else if ("logout".equals(action))
        {
            processLogout(response, request);
        }
    }

    private void processLogout(HttpServletResponse response, HttpServletRequest request) throws IOException
    {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/user?action=login");
    }

    private void processLoginSubmit(HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String imageCode = request.getParameter("imageCode");

        if (Utils.isEmptyOrNotEmail(email))
        {
            request.setAttribute("message", "请输入正确的邮箱格式");
            request.getRequestDispatcher("/WEB-INF/jsp/userLogin.jsp").forward(request, response);
            return;
        }
        if (Utils.isEmptyOrNotLengthEnough(password, 6))
        {
            request.setAttribute("message", "密码至少6位");
            request.getRequestDispatcher("/WEB-INF/jsp/userLogin.jsp").forward(request, response);
            return;
        }
        if (Utils.isNotMatchImageCode(imageCode, request.getSession()))
        {
            request.setAttribute("message", "验证码不正确，请重新输入");
            request.getRequestDispatcher("/WEB-INF/jsp/userLogin.jsp").forward(request, response);
            return;
        }

        User user = userService.login(email, Utils.md5(password));
        if (user == null)
        {
            request.setAttribute("message", "邮箱或密码错误");
            request.getRequestDispatcher("/WEB-INF/jsp/userLogin.jsp").forward(request, response);
            return;
        }

        // 登录成功后，需要把user对象设置到session
        request.getSession().setAttribute("user", user);

        // 判断用户角色，如果是管理员的话，就把请求重定向到ManagerServlet
        if ("manager".equals(user.getRole()))
        {
            response.sendRedirect(request.getContextPath() + "/manager");
            return;
        }
        response.sendRedirect(request.getServletContext().getContextPath());
        // request.getServletContext().getContextPath()就是项目的目录
    }

    private void processLogin(HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/userLogin.jsp").forward(request, response);
    }

    private void prcessRegisterSubmit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String imageCode = request.getParameter("imageCode");

        if (Utils.isNotMatchImageCode(imageCode, request.getSession()))
        {
            // 不匹配
            request.setAttribute("message", "验证码不正确，请重新输入");
            request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp").forward(request, response);
            return;
        }

        if (Utils.isEmptyOrNotEmail(email))
        {
            // 检查失败
            request.setAttribute("message", "请输入正确的邮箱格式");
            request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp").forward(request, response);
            return;
        }
        else
        {
            if (!userService.emailIsNotExist(email))
            {
                request.setAttribute("message", "此邮箱已经被注册过");
                request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp").forward(request, response);
                return;
            }
        }

        if (Utils.isEmptyOrNotLengthEnough(password, 6))
        {
            request.setAttribute("message", "密码至少6位");
            request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(Utils.md5(password));// md5加密

        userService.register(user);

        request.setAttribute("message", "注册成功，请登录");
        request.getRequestDispatcher("/WEB-INF/jsp/userLogin.jsp").forward(request, response);
    }

    private void processRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/userRegister.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}
