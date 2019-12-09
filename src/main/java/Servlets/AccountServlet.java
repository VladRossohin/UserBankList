package Servlets;

import Entity.Account;
import Services.AccountService;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class AccountServlet extends HttpServlet {

    private Account account = new Account();
    private AccountService accountService = new AccountService();
    private Long sum;

    public void init() throws ServletException {
        super.init();
        try {
            sum = accountService.getSumOfAccounts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("sum", sum);
        response.sendRedirect("account.jsp");
    }

}
