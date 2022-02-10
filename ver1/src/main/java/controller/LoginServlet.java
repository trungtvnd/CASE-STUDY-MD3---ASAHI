package controller;

import model.Account;
import service.account.AccountDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final AccountDAO accountDAO = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> accounts = accountDAO.selectAll();
        RequestDispatcher requestDispatcher;
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        boolean accountCheck = false;
        for (Account account: accounts ) {
            if((account.getName().equals(user))  && (account.getPassword().equals(pass))){
                req.setAttribute("account", account);
                accountCheck = true;
                requestDispatcher = req.getRequestDispatcher("login/home.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
        if(!accountCheck){
            requestDispatcher = req.getRequestDispatcher("login/login.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
