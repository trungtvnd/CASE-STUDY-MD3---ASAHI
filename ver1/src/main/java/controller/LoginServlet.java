package controller;

import model.Account;
import model.Author;
import model.Position;
import model.Publish;
import service.account.AccountDAO;
import service.author.AuthorDAO;
import service.position.PositionDao;
import service.publish.PublishDAO;

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
    private final AuthorDAO authorDAO = new AuthorDAO();
    private final PublishDAO publishDAO = new PublishDAO();
    private final PositionDao positionDao = new PositionDao();

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
                req.setAttribute("account", account.getName());
                accountCheck = true;
                List<Publish> publishes = publishDAO.selectAll();
                List<Position> positions = positionDao.selectAll();
                List<Author> authors = authorDAO.selectAll();
                req.setAttribute("username", user);
                req.setAttribute("authors", authors);
                req.setAttribute("positions", positions);
                req.setAttribute("publishes", publishes);
                requestDispatcher = req.getRequestDispatcher("login/home1.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
        if(!accountCheck){
            requestDispatcher = req.getRequestDispatcher("login/login.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}
