package controller;

import model.Position;
import model.Publish;
import service.position.PositionDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/positions")
public class PositionServlet extends HttpServlet {

    PositionDao positionDao = new PositionDao();

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
                    showEditForm(req, resp);
                    break;
                case "delete":
                    delete(req, resp);
                    break;
                default:
                    listPosition(req, resp);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            positionDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Position> listPosition = positionDao.selectAll();
        req.setAttribute("positions", listPosition);
        RequestDispatcher dispatcher = req.getRequestDispatcher("position/view.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Position position = positionDao.select(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("position/edit.jsp");
        req.setAttribute("position", position);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createGet(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("position/create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listPosition(HttpServletRequest req, HttpServletResponse resp) {
        List<Position> positions = positionDao.selectAll();
        req.setAttribute("positions", positions);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("position/view.jsp");
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
                update(req, resp);
                break;
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String describe = req.getParameter("describe");
        int quantityLimit = Integer.parseInt(req.getParameter("quantityLimit"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Position position = new Position(id, name, describe, quantityLimit, quantity);
        try {
            positionDao.update(position);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("position/edit.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createPost(HttpServletRequest req, HttpServletResponse resp) {

        String name = req.getParameter("name");
        String describe = req.getParameter("describe");
        int quantityLimit = Integer.parseInt(req.getParameter("quantityLimit"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        try {
            try {
                positionDao.insert(new Position(name, describe, quantityLimit, quantity));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("position/create.jsp");
            try {
                requestDispatcher.forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
