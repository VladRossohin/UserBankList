package Servlets;

import Entity.User;
import Services.AccountService;
import Services.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


public class UserServlet extends HttpServlet {
    private User user = new User();
    private UserService userService = new UserService();
    public void init() throws ServletException {
        super.init();
        try {
            user = userService.getRichestUser();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getErrorCode());
            System.out.println("ERROR");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.sendRedirect("user.jsp");
/*
        PrintWriter printWriter = response.getWriter();
        request.setAttribute("truePage", this.getServletName());
        request.setAttribute("user", user);
        request.setAttribute("userId", user.getUserId());
        request.setAttribute("userName", user.getName());
        request.setAttribute("userSurName", user.getSurName());

       // RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../../web/index.jsp");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/../web/index.jsp");
        requestDispatcher.forward(request,response);*/
    }
}
