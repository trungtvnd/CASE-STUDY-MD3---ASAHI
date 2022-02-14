package controller;

import model.*;
import service.author.AuthorDAO;
import service.book.BookDAO;
import service.join.JoinDAO;
import service.position.PositionDao;
import service.publish.PublishDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.text.*;


@WebServlet(urlPatterns = "/books")
public class BookServlet extends HttpServlet {

    private final BookDAO bookDAO = new BookDAO();
    private final AuthorDAO authorDAO = new AuthorDAO();
    private final PublishDAO publishDAO = new PublishDAO();
    private final PositionDao positionDao = new PositionDao();
    private final JoinDAO joinPositionDAO = new JoinDAO();

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
                    delete(req, resp);
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
                case "sortByPublish":
                    sortByPublish(req, resp);
                    break;
                case "sortByAuthor":
                    sortByAuthor(req, resp);
                    break;
                case "sortByPosition":
                    sortByPosition(req, resp);
                    break;
                case "sortByType":
                    sortByType(req, resp);
                    break;

                default:
                    listBook(req, resp);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void sortByType(HttpServletRequest req, HttpServletResponse resp) {
        List<Publish> publishes = publishDAO.selectAll();
        req.setAttribute("publishes", publishes);
        List<Position> positions = positionDao.selectAll();
        List<Author> authors = authorDAO.selectAll();
        req.setAttribute("authors", authors);
        req.setAttribute("positions", positions);
        String type = ("%" + req.getParameter("type") + "%");
        List<Book> books = bookDAO.selectBookByType(type);
        int quantityOfType = bookDAO.searchQuantityOfType(type);
        boolean checkView = true;
        int quantity = bookDAO.selectQuantityAllBook();
        req.setAttribute("books", books);
        req.setAttribute("checkView", checkView);
        req.setAttribute("quantityAllBook", quantityOfType);
        req.setAttribute("books", books);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("library/view1.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void joinType(HttpServletRequest req, HttpServletResponse resp) {
        List<JoinType> joinTypes = joinPositionDAO.selectAllType();
        req.setAttribute("joinTypes", joinTypes);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("joinType/view1.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void joinStatus(HttpServletRequest req, HttpServletResponse resp) {
        List<JoinStatus> joinStatuses = joinPositionDAO.selectAllStatus();
        req.setAttribute("joinStatuses", joinStatuses);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("joinStatus/view1.jsp");
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
        if (book == null) {
            requestDispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("book", book);
            requestDispatcher = req.getRequestDispatcher("library/viewBook.jsp");
        }
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        int idPosition = positionDao.searchIDPosition(id);
        try {
            bookDAO.deleteBook(id);
            positionDao.minusQuantityPosition(positionDao.select(idPosition));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        int quantity = bookDAO.selectQuantityAllBook();
        List<Book> books = bookDAO.selectAllBook();
        req.setAttribute("quantityAllBook", quantity);
        req.setAttribute("books", books);
        RequestDispatcher dispatcher = req.getRequestDispatcher("library/view1.jsp");
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
        int index = Integer.parseInt(req.getParameter("index"));
        boolean checkView = true;
        int quantity = bookDAO.selectQuantityAllBook();
        int pageSize = 20;
        int endPage = 0;
        endPage = quantity / pageSize;
        if (quantity % pageSize != 0) {
            endPage++;
        }
        List<Book> books = bookDAO.displayByPage(index, pageSize);
        req.setAttribute("books", books);
        req.setAttribute("checkView", checkView);
        req.setAttribute("quantityAllBook", quantity);
        req.setAttribute("endPage", endPage);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("library/view1.jsp");
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
        switch (action) {
            case "create":
                createPost(req, resp);
                break;
            case "edit":
                editPost(req, resp);
                break;
            case "search":
                searchBook(req, resp);


        }
    }

    private void sortByPublish(HttpServletRequest req, HttpServletResponse resp) {

        List<Publish> publishes = publishDAO.selectAll();
        List<Position> positions = positionDao.selectAll();
        String namePublish = req.getParameter("sortByPublish");
        List<Author> authors = authorDAO.selectAll();
        req.setAttribute("authors", authors);
        req.setAttribute("publishes", publishes);
        req.setAttribute("positions", positions);
        String username = req.getParameter("name");
        List<Book> books = bookDAO.sortBookByPublish(namePublish);
        boolean check = true;
        int quantity = joinPositionDAO.selectQuantityPublish(namePublish);
        req.setAttribute("books", books);
        req.setAttribute("checkPublish", check);
        req.setAttribute("quantityPublish", quantity);
        req.setAttribute("username", username);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("library/view1.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sortByPosition(HttpServletRequest req, HttpServletResponse resp) {

        List<Author> authors = authorDAO.selectAll();
        List<Publish> publishes = publishDAO.selectAll();
        List<Position> positions = positionDao.selectAll();
        String namePosition = req.getParameter("sortByPosition");
        req.setAttribute("positions", positions);
        req.setAttribute("publishes", publishes);
        req.setAttribute("authors", authors);

        List<Book> books = bookDAO.sortBookByPosition(namePosition);
        boolean check = true;
        int quantity = joinPositionDAO.selectQuantityPosition(namePosition);
        req.setAttribute("books", books);
        req.setAttribute("checkPosition", check);
        req.setAttribute("quantityPosition", quantity);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("library/view1.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sortByAuthor(HttpServletRequest req, HttpServletResponse resp) {
        String nameAuthor = req.getParameter("sortByAuthor");
        List<Author> authors = authorDAO.selectAll();
        List<Publish> publishes = publishDAO.selectAll();
        List<Position> positions = positionDao.selectAll();

        req.setAttribute("authors", authors);
        req.setAttribute("positions", positions);
        req.setAttribute("publishes", publishes);
        List<Book> books = bookDAO.sortBookByAuthor(nameAuthor);
        req.setAttribute("books", books);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("library/view1.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void editPost(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher;
        int id = Integer.parseInt(req.getParameter("id"));
        String name = new String(req.getParameter("name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        int authorID = Integer.parseInt(req.getParameter("authorID"));
        String describe = new String(req.getParameter("describe").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String language = new String(req.getParameter("language").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String status = req.getParameter("status");
        String type = req.getParameter("type");
        int publish = Integer.parseInt(req.getParameter("publish"));
        int positionID = Integer.parseInt(req.getParameter("positionID"));
        String yearPublish = req.getParameter("yearPublish");
        String image = req.getParameter("image");

        try{
            int idPosition = positionDao.searchIDPosition(id);
            int quantityAfterEdit = positionDao.getQuantityPosition(positionID) + 1;
            req.setAttribute("check", quantityAfterEdit);
            if (quantityAfterEdit <= 10) {
                positionDao.minusQuantityPosition(positionDao.select(idPosition));
                Book book = new Book(id, name, describe, language, status, type, yearPublish, image);
                try {
                    bookDAO.updateBook(book, authorID, positionID, publish);
                    positionDao.plusQuantityPosition(positionDao.select(positionID));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        requestDispatcher = req.getRequestDispatcher("library/edit.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createPost(HttpServletRequest req, HttpServletResponse resp) {
//        System.out.println("Original name: " + req.getParameter("name"));

        String name = new String(req.getParameter("name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//        System.out.println("Transform name: " + name);
        int author = Integer.parseInt(req.getParameter("author"));
        String describe = new String(req.getParameter("describe").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String language = req.getParameter("language");
        String status = req.getParameter("status");
        String type = req.getParameter("type");
        int publish = Integer.parseInt(req.getParameter("publish"));
        int positionID = Integer.parseInt(req.getParameter("position"));
        String yearPublish = req.getParameter("yearPublish");
        String image = req.getParameter("image");
        RequestDispatcher requestDispatcher;
        try {
            int quantityAfterCreate = positionDao.getQuantityPosition(positionID) + 1;
            if (quantityAfterCreate <= 10) {
                Book book = new Book(name, describe, language, status, type, yearPublish, image);

                bookDAO.insertBook(book, author, positionID, publish);
                positionDao.plusQuantityPosition(positionDao.select(positionID));
                req.setAttribute("check", quantityAfterCreate);
                List<Publish> publishes = publishDAO.selectAll();
                List<Author> authors = authorDAO.selectAll();
                List<Position> positions = positionDao.selectAll();
                req.setAttribute("authors", authors);
                req.setAttribute("positions", positions);
                req.setAttribute("publishes", publishes);
                requestDispatcher = req.getRequestDispatcher("library/create.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                req.setAttribute("check", quantityAfterCreate);
                requestDispatcher = req.getRequestDispatcher("library/create.jsp");
                requestDispatcher.forward(req, resp);
            }


        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    public void searchBook(HttpServletRequest request, HttpServletResponse response) {

        List<Book> books = bookDAO.searchBook("%" + new String(request.getParameter("searchBook").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) + "%");
        request.setAttribute("books", books);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("library/view1.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void searchBookPBL(HttpServletRequest request, HttpServletResponse response) {
        List<Book> books = bookDAO.searchBookByPBL("%" + request.getParameter("searchBookByPBL") + "%", "%" + request.getParameter("searchBook") + "%");
        request.setAttribute("books", books);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("library/view1.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sortBook(HttpServletRequest req, HttpServletResponse resp) {
        String sort = req.getParameter("sort");
        if (sort.equals("Publish")) {
            List<Publish> publishes = publishDAO.selectAll();
            req.setAttribute("publishes", publishes);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("library/view1.jsp");
            try {
                requestDispatcher.forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

}
