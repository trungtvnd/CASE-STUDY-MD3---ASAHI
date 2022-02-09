package controller;

import model.Account;
import service.account.AccountDAO;
import service.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet  extends HttpServlet {
    private final AccountDAO accountDAO = new AccountDAO();
    List<Account> accounts = accountDAO.selectAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("register/register.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        boolean accountCheck = false;
        for (Account account: accounts ) {
            if((account.getName().equals(name)) && (account.getEmail().equals(email)) && (account.getPassword().equals(pass))){
                req.setAttribute("account", account);
                accountCheck = true;
                requestDispatcher = req.getRequestDispatcher("login/home.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
        if(!accountCheck){
            requestDispatcher = req.getRequestDispatcher("register/register.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
