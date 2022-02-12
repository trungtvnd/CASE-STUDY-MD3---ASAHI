package service.user;

import model.Account;
import model.User;
import myConnection.MyConnection;
import InterfaceDAO.InterfaceDAO;
import service.account.AccountDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements InterfaceDAO<User> {
private final MyConnection myConnection = new MyConnection();
    private final AccountDAO accountDAO = new AccountDAO();


    private static final String INSERT_USER_SQL = "INSERT INTO users (userName, birth, idEmail,phoneNumber, image) VALUES (?, ?, ?,?,?);";
    private static final String UPDATE_USER_SQL = "update users set userName = ?,birth= ?, phoneNumber =?, image =? where id = ?;";
    private static final String SELECT_ALL_USER = "select * from users";
    private static final String SELECT_USER_BY_ID = "select id,userName,birth,idEmail,phoneNumber, image from users where id =?";
    private static final String SELECT_USER_BY_EMAIL = "select id,userName,birth,idEmail,phoneNumber, image from users where idEmail =?";

    private static final String SELECT_USER_BY_JOIN = "SELECT users.id 'id',  users.userName 'username', users.birth 'birth', accounts.email 'email', users.phoneNumber 'phone', users.image 'image'" +
            "FROM accounts\n" +
            "JOIN users ON users.idEmail = accounts.id \n"+
            "Where accounts.id = ?";

    public UserDAO() {
    }


    @Override
    public void insert(User user) throws SQLException {
        System.out.println(INSERT_USER_SQL);
        try (Connection connection = myConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getBirth());
            preparedStatement.setInt(3, searchIDAccount(user.getEmail()));
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getImage());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public User select(int id) {
        User user = null;
        try (Connection connection = myConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("userName");
                int birth = Integer.parseInt(rs.getString("birth"));
                String email = rs.getString("idEmail");
                String phoneNumber = rs.getString("phoneNumber");
                String image = rs.getString("image");
                user = new User(id, name, birth, email, phoneNumber, image);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }


    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = myConnection.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("userName");
                int birth = Integer.parseInt(rs.getString("birth"));
                String email = rs.getString("idEmail");
                String phoneNumber = rs.getString("phoneNumber");
                String image = rs.getString("image");
                users.add(new User(id, name, birth, email, phoneNumber, image));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = myConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, String.valueOf(user.getBirth()));
            statement.setString(3, user.getPhoneNumber());
            statement.setString(4, user.getImage());
            statement.setInt(5, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public int searchIDAccount(String email) {
        int idAccount = 0;
        List<Account> accounts = accountDAO.selectAll();
        for (Account account : accounts) {
            if (account.getEmail().equals(email)) {
                idAccount = account.getId();
            }
        }
        return idAccount;
    }

    public User selectUserByIDEmail(int idEmail) {
        User user = null;
        try (Connection connection = myConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_JOIN);) {
            preparedStatement.setInt(1, idEmail);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                int birth = Integer.parseInt(rs.getString("birth"));
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone");
                String image = rs.getString("image");
                user = new User(id, name, birth, email, phoneNumber, image);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;

    }
}
