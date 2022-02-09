package controller;

import model.*;
import service.author.AuthorDAO;
import service.book.BookDAO;
import service.join.JoinPositionDAO;
import service.position.PositionDao;
import service.publish.PublishDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/books")
public class BookServlet extends HttpServlet {

    private final BookDAO bookDAO = new BookDAO();
    private final AuthorDAO authorDAO = new AuthorDAO();
    private final PublishDAO publishDAO = new PublishDAO();
    private final PositionDao positionDao = new PositionDao();
    private final JoinPositionDAO joinPositionDAO = new JoinPositionDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createGet(req, resp);
                    break;
                case "edit":
                    editGet(req, resp);
                    break;
                case "delete":
                    delete(req,resp);
                    break;
                case "view":
                    view(req, resp);
                    break;
                case "joinPosition":
                    joinPosition(req, resp);
                    break;
                case "joinStatus":
                    joinStatus(req, resp);
                    break;
                case "joinType":
                    joinType(req, resp);
                    break;

                default:
                    listBook(req, resp);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void joinType(HttpServletRequest req, HttpServletResponse resp) {
        List<JoinType> joinTypes = joinPositionDAO.selectAllType();
        req.setAttribute("joinTypes", joinTypes);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("joinType/view.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void joinStatus(HttpServletRequest req, HttpServletResponse resp) {
        List<JoinStatus> joinStatuses = joinPositionDAO.selectAllStatus();
        req.setAttribute("joinStatuses", joinStatuses);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("joinStatus/view.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void joinPosition(HttpServletRequest req, HttpServletResponse resp) {
        List<JoinPosition> joinPositions = joinPositionDAO.selectAllPosition();
        req.setAttribute("joinPositions", joinPositions);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("joinPosition/view.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void view(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookDAO.selectBook(id);
        RequestDispatcher requestDispatcher;
        if(book==null){
            requestDispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            req.setAttribute("book", book);
            requestDispatcher = req.getRequestDispatcher("library/viewBook.jsp");
        }
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            bookDAO.deleteBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Book> books = bookDAO.selectAllBook();
        req.setAttribute("books", books);
        RequestDispatcher dispatcher = req.getRequestDispatcher("library/view.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Author> authors = authorDAO.selectAll();
        List<Position> positions = positionDao.selectAll();
        List<Publish> publishes = publishDAO.selectAll();
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookDAO.selectBook(id);
        req.setAttribute("book", book);
        req.setAttribute("authors", authors);
        req.setAttribute("positions", positions);
        req.setAttribute("publishes", publishes);
        RequestDispatcher dispatcher = req.getRequestDispatcher("library/edit.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Author> authors = authorDAO.selectAll();
        List<Position> positions = positionDao.selectAll();
        List<Publish> publishes = publishDAO.selectAll();
        req.setAttribute("authors", authors);
        req.setAttribute("positions", positions);
        req.setAttribute("publishes", publishes);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("library/create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listBook(HttpServletRequest req, HttpServletResponse resp) {
        List<Book> books = bookDAO.selectAllBook();
        req.setAttribute("books", books);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("library/view.jsp");
        try {
            requestDispatcher.forward(req, resp);
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
        switch (action){
            case "create":
                createPost(req, resp);
                break;
            case "edit":
                editPost(req, resp);
                break;
        }
    }

    private void editPost(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher;
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int authorID = Integer.parseInt(req.getParameter("authorID"));
        String describe = req.getParameter("describe");
        String language = req.getParameter("language");
        String status = req.getParameter("status");
        String type = req.getParameter("type");
        int publish = Integer.parseInt(req.getParameter("publish"));
        int positionID = Integer.parseInt(req.getParameter("positionID"));
        String yearPublish = req.getParameter("yearPublish");
        String image = req.getParameter("image");

        Book book = new Book(id,name, describe, language, status, type, yearPublish, image);
        try {
            bookDAO.updateBook(book, authorID, positionID, publish);
        } catch (SQLException e) {
            e.printStackTrace();
        }
         requestDispatcher = req.getRequestDispatcher("library/edit.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        int author = Integer.parseInt(req.getParameter("author"));
        String describe = req.getParameter("describe");
        String language = req.getParameter("language");
        String status = req.getParameter("status");
        String type = req.getParameter("type");
        int publish = Integer.parseInt(req.getParameter("publish"));
        int positionID = Integer.parseInt(req.getParameter("position"));
        String yearPublish = req.getParameter("yearPublish");
        String image = req.getParameter("image");
        try {
            Book book = new Book(name, describe, language, status, type, yearPublish, image);
            bookDAO.insertBook(book, author, positionID, publish);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("library/create.jsp");
            try {
                requestDispatcher.forward(req,resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
