package controller;

import model.Author;
import service.author.AuthorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/authors")
public class AuthorServlet extends HttpServlet {
    AuthorDAO authorDAO = new AuthorDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showNewForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            default:
                listAuthor(req, resp);

        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            authorDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Author> listAuthor = authorDAO.selectAll();
        req.setAttribute("listAuthor", listAuthor);
        RequestDispatcher dispatcher = req.getRequestDispatcher("author/view.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Author author = authorDAO.select(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("author/edit.jsp");
        req.setAttribute("author", author);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("author/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void listAuthor(HttpServletRequest req, HttpServletResponse resp)  {
        List<Author> listAuthor = authorDAO.selectAll();
        req.setAttribute("listAuthor", listAuthor);
        RequestDispatcher dispatcher = req.getRequestDispatcher("author/view.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insert(req, resp);
                    break;
                case "edit":
                    update(req, resp);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");

        Author author = new Author(id, name, address, email);
        try {
            authorDAO.update(author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("author/edit.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        Author author = new Author(name, address, email);
        try {
            authorDAO.insert(author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("author/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
