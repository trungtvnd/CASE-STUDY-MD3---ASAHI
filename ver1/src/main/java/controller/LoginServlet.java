package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if(user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")){
             requestDispatcher = req.getRequestDispatcher("login/home.jsp");
            requestDispatcher.forward(req, resp);
        }else {
            requestDispatcher = req.getRequestDispatcher("login/login.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
