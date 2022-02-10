package service.position;

import model.Position;
import service.InterfaceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDao implements InterfaceDAO<Position> {
    private String jdbcURL = "jdbc:mysql://localhost:3306/librarymanagement1?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_POSITION_SQL = "INSERT INTO positions (name, describePosition, quantityLimit, quantity) VALUES (?, ?, ?, ?);";
    private static final String SELECT_POSITION_BY_ID = "select id,name,describePosition,quantityLimit,quantity from positions where id =?";
    private static final String SELECT_ALL_POSITION = "select * from positions";
    private static final String UPDATE_POSITION_SQL = "update positions set name = ?,describePosition= ?, quantityLimit =? ,quantity = ? where id = ?;";
    private static final String SELECT_POSITION_BY_NAME = "select id,name,describePosition,quantityLimit,quantity from positions where name =?";
    private static final String UPDATE_POSITION_QUANTITY = "update positions set quantity = ? where id = ?;";



    public PositionDao() {
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
    public void insert(Position position) throws SQLException {
        System.out.println(INSERT_POSITION_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POSITION_SQL)) {
            preparedStatement.setString(1, position.getName());
            preparedStatement.setString(2, position.getDescribe());
            preparedStatement.setInt(3, position.getQuantityLimit());
            preparedStatement.setInt(4, position.getQuantity());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Position select(int id) {
        Position position = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String describePosition = rs.getString("describePosition");
                int quantityLimit = rs.getInt("quantityLimit");
                int quantity = rs.getInt("quantity");
                position = new Position(id, name, describePosition, quantityLimit, quantity);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return position;
    }

    @Override
    public List<Position> selectAll() {
        List<Position> positions = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String describePosition = rs.getString("describePosition");
                int quantityLimit = rs.getInt("quantityLimit");
                int quantity = rs.getInt("quantity");
                positions.add(new Position(id, name, describePosition, quantityLimit, quantity));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return positions;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Position position) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_POSITION_SQL);) {
            statement.setString(1, position.getName());
            statement.setString(2, position.getDescribe());
            statement.setInt(3, position.getQuantityLimit());
            statement.setInt(4, position.getQuantity());
            statement.setInt(5, position.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public Position select(String name) {
        Position position = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION_BY_NAME);) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String describePosition = rs.getString("describePosition");
                int quantityLimit = rs.getInt("quantityLimit");
                int quantity = rs.getInt("quantity");
                position = new Position(id, name, describePosition, quantityLimit, quantity);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return position;
    }

    public boolean plusQuantityPosition(Position position) throws SQLException{
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_POSITION_QUANTITY);) {
            statement.setInt(1, position.getQuantity() + 1);
            statement.setInt(2, position.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;

    }
}
