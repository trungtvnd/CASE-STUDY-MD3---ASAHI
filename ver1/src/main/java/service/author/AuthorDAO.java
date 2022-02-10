package service.author;

import model.Author;
import service.InterfaceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO implements InterfaceDAO<Author> {
    private String jdbcURL = "jdbc:mysql://localhost:3306/librarymanagement1?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_AUTHORS_SQL = "INSERT INTO author (name, address, email) VALUES (?, ?, ?);";
    private static final String SELECT_AUTHORS_BY_ID = "select id,name,address,email from author where id =?";
    private static final String SELECT_ALL_AUTHORS = "select * from author";
    private static final String UPDATE_AUTHORS_SQL = "update author set name = ?,address= ?, email =? where id = ?;";

    public AuthorDAO(){}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insert(Author author) throws SQLException {
        System.out.println(INSERT_AUTHORS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHORS_SQL)) {
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getAddress());
            preparedStatement.setString(3, author.getEmail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Author select(int id) {
        Author author = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHORS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                author = new Author(id, name,address , email);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return author;
    }

    @Override
    public List<Author> selectAll() {
        List<Author> authors = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHORS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                authors.add(new Author(id, name, address, email));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return authors;
    }

    @Override
    public boolean delete(int id) throws SQLException {
    return false;
    }

    @Override
    public boolean update(Author author) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHORS_SQL);) {
            statement.setString(1, author.getName());
            statement.setString(2, author.getAddress());
            statement.setString(3, author.getEmail());
            statement.setInt(4, author.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}
