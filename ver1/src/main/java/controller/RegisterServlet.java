package controller;

import model.*;
import service.account.AccountDAO;
import service.user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet  extends HttpServlet {
    private final AccountDAO accountDAO = new AccountDAO();
    private final UserDAO userDAO = new UserDAO();
    private final List<User> users = userDAO.selectAll();

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
                case "createUser":
                    createUserGet(req, resp);
                    break;
                case "displayUser":
                    displayUser(req, resp);
                    break;
                case "editUser":
                    editUserGet(req, resp);
                    break;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createUserGet(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        Account account = searchAccountByAccountName(username);
        req.setAttribute("account", account);
       RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/create.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
    public Account searchAccountByAccountName(String accountName){
        List<Account>accounts = accountDAO.selectAll();
        Account accountSearch = null;
        for (Account account:accounts) {
            if(account.getName().equals(accountName)){
                accountSearch = account;
            }
        }return accountSearch;
    }

    private void editUserGet(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userDAO.selectUserByIDEmail(searchIDAccount(searchUsername(id)));
        boolean check = true;
        req.setAttribute("checkEdit", check);
        req.setAttribute("user", user);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/viewDetail.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void displayUser(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        User user = userDAO.selectUserByIDEmail(searchIDAccount(username));
        boolean check = true;
        req.setAttribute("username", username);
        req.setAttribute("user", user);
        req.setAttribute("checkView", check);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/viewDetail.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private int searchIDAccount(String username) {
        List<Account> accounts = accountDAO.selectAll();
        int idAccount = 0;
        for (Account account:accounts) {
            if(account.getName().equals(username)){
                idAccount = account.getId();
            }
        }return idAccount;
    }



    private void editGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Account> accounts = accountDAO.selectAll();
        int id = Integer.parseInt(req.getParameter("id"));
        Account account = accountDAO.select(id);
        req.setAttribute("account", account);
        RequestDispatcher dispatcher = req.getRequestDispatcher("account/edit.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("register/register.jsp");
        requestDispatcher.forward(req,resp);
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
            case "creatUser":
              createUser(req, resp);
                break;
//            case "editUser":
//                editUser(req, resp);
//                break;
            case "editUser":
                editUserPost(req, resp);
                break;
        }
    }

    private void editUserPost(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        int birth = Integer.parseInt(req.getParameter("birth"));
        String email = req.getParameter("email");
        String image = req.getParameter("image");
        User user = new User(id, name, birth, email, phone, image );
        try {
            userDAO.update(user);
            boolean check = true;
            req.setAttribute("user", user);
            req.setAttribute("checkView", check);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/viewDetail.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("name");
        int birth = Integer.parseInt(req.getParameter("birth"));
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        String image = req.getParameter("image");

        User user = new User(username, birth, email, phoneNumber, image);
        try {
            userDAO.insert(user);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/create.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String passRe = req.getParameter("passwordRe");

        Account account = new Account(id,name, email, pass);
        try {
            accountDAO.update(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        requestDispatcher = req.getRequestDispatcher("account/edit.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher requestDispatcher;
        List<Account> accounts = accountDAO.selectAll();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        boolean accountCheck = false;
        for (Account account: accounts ) {
            if((account.getName().equals(name)) || (account.getEmail().equals(email)) ){
                req.setAttribute("account", account);
                accountCheck = true;
                requestDispatcher = req.getRequestDispatcher("register/register.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
        if(!accountCheck){
            Account account = new Account(name,email,pass);
            try {
                accountDAO.insert(account);
                req.setAttribute("account", account);
                requestDispatcher= req.getRequestDispatcher("user/create.jsp");
                requestDispatcher.forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public String searchUsername(int idUser){
        List<User> users = userDAO.selectAll();
        List<Account> accounts = accountDAO.selectAll();
        String username = null;
        int idEmail = 0;
        for (User user:users) {
            if(user.getId() == idUser){
                idEmail = Integer.parseInt(user.getEmail());
            }
        }
        for (Account account:accounts) {
            if(idEmail == account.getId()){
                username = account.getName();
            }
        }return username;
    }


}
