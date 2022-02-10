package service.publish;

import model.Author;
import model.Publish;
import service.InterfaceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublishDAO implements InterfaceDAO<Publish> {
    private String jdbcURL = "jdbc:mysql://localhost:3306/librarymanagement1?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String INSERT_PUBLISH_SQL = "INSERT INTO publish (name, address, email) VALUES (?, ?, ?);";
    private static final String SELECT_PUBLISH_BY_ID = "select id,name,address,email from publish where id =?";
    private static final String SELECT_ALL_PUBLISH = "select * from publish";
    private static final String UPDATE_PUBLISH_SQL = "update publish set name = ?,address= ?, email =? where id = ?;";

    public PublishDAO() {
    }

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
    public void insert(Publish publish) throws SQLException {
        System.out.println(INSERT_PUBLISH_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PUBLISH_SQL)) {
            preparedStatement.setString(1, publish.getName());
            preparedStatement.setString(2, publish.getAddress());
            preparedStatement.setString(3, publish.getEmail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Publish select(int id) {
        Publish publish = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PUBLISH_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                publish = new Publish(id, name, address, email);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return publish;
    }

    @Override
    public List<Publish> selectAll() {
        List<Publish> publishes = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PUBLISH);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                publishes.add(new Publish(id, name, address, email));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return publishes;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Publish publish) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PUBLISH_SQL);) {
            statement.setString(1, publish.getName());
            statement.setString(2, publish.getAddress());
            statement.setString(3, publish.getEmail());
            statement.setInt(4, publish.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
