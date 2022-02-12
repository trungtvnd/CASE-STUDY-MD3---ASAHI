package service.account;

import model.Account;
import myConnection.MyConnection;
import InterfaceDAO.InterfaceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements InterfaceDAO<Account> {
    private final MyConnection myConnection = new MyConnection();

    private static final String INSERT_ACCOUNT_SQL = "INSERT INTO accounts (name, email, password) VALUES (?, ?, ?);";
    private static final String UPDATE_ACCOUNT_SQL = "update accounts set name = ?, password =? where id = ?;";
    private static final String SELECT_ACCOUNT_BY_ID = "select id,name,email,password from accounts where id =?";
    private static final String SELECT_ALL_ACCOUNT = "select * from accounts";

    public AccountDAO() {
    }


    @Override
    public void insert(Account account) throws SQLException {
        System.out.println(INSERT_ACCOUNT_SQL);
        try (Connection connection = myConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT_SQL)) {
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getEmail());
            preparedStatement.setString(3, account.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Account select(int id) {
        Account account = null;
        try (Connection connection = myConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String pass = rs.getString("password");
                account = new Account(id, name, email, pass);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return account;
    }

    @Override
    public List<Account> selectAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = myConnection.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String pass = rs.getString("password");
                accounts.add(new Account(id, name, email, pass));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accounts;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Account account) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = myConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNT_SQL);) {
            statement.setString(1, account.getName());
            statement.setString(2, account.getPassword());
            statement.setInt(3, account.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
