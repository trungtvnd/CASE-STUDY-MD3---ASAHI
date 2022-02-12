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
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "home":
                backHome(req, resp);
                break;
            default:
                loginGet(req, resp);
        }

    }

    private void backHome(HttpServletRequest req, HttpServletResponse resp) {
        List<Publish> publishes = publishDAO.selectAll();
        List<Position> positions = positionDao.selectAll();
        List<Author> authors = authorDAO.selectAll();
        req.setAttribute("authors", authors);
        req.setAttribute("positions", positions);
        req.setAttribute("publishes", publishes);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login/home1.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    public void loginGet(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login/login.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                loginPost(req, resp);
        }
    }

    public void loginPost(HttpServletRequest request, HttpServletResponse response) {
        List<Account> accounts = accountDAO.selectAll();
        RequestDispatcher requestDispatcher;
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        boolean accountCheck = false;
        for (Account account : accounts) {
            if ((account.getName().equals(user)) && (account.getPassword().equals(pass))) {
                accountCheck = true;
                List<Publish> publishes = publishDAO.selectAll();
                List<Position> positions = positionDao.selectAll();
                List<Author> authors = authorDAO.selectAll();
                request.setAttribute("account", account);
                request.setAttribute("authors", authors);
                request.setAttribute("positions", positions);
                request.setAttribute("publishes", publishes);
                requestDispatcher = request.getRequestDispatcher("login/home1.jsp");
                try {
                    requestDispatcher.forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!accountCheck) {
            requestDispatcher = request.getRequestDispatcher("login/login.jsp");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
