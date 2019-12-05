package Servlets;

import Entity.User;
import Services.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class UserServlet extends HttpServlet {
    private List<User> user;
    private UserService userService = new UserService();

    public void init() throws ServletException {
        super.init();
        try {
            user = userService.getRichestUser();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getErrorCode());
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        request.setAttribute("richestUser", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../../web/index.jsp");
        requestDispatcher.forward(request,response);
    }
}
