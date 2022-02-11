package service.join;

import model.JoinPosition;
import model.JoinPublish;
import model.JoinStatus;
import model.JoinType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JoinDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/librarymanagement1?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String JOIN_POSITION = "SELECT * FROM joinposition";
    private static final String JOIN_STATUS = "SELECT * FROM joinstatus";
    private static final String JOIN_TYPE = "SELECT * FROM jointype";
    private static final String JOIN_PUBLISH = "SELECT * FROM joinpublish";


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

    public List<JoinPosition> selectAllPosition() {
        List<JoinPosition> joinPositions = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(JOIN_POSITION);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Position name");
                int quantity = rs.getInt("Count book");

                joinPositions.add(new JoinPosition(name,quantity));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return joinPositions;
    }

    public List<JoinStatus> selectAllStatus() {
        List<JoinStatus> joinStatuses = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(JOIN_STATUS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String status = rs.getString("Status");
                int quantity = rs.getInt("Quantity");

                joinStatuses.add(new JoinStatus(status,quantity));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return joinStatuses;
    }

    public List<JoinType> selectAllType() {
        List<JoinType> joinTypes = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(JOIN_TYPE);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String type = rs.getString("Type");
                int quantity = rs.getInt("Quantity");

                joinTypes.add(new JoinType(type,quantity));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return joinTypes;
    }

    public List<JoinPublish> selectAllPublish() {
        List<JoinPublish> joinPublishes = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(JOIN_PUBLISH);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");

                joinPublishes.add(new JoinPublish(name,quantity));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return joinPublishes;
    }

    public int selectQuantityPublish(String name){
        int quantity = 0;
        List<JoinPublish> publishes = selectAllPublish();
        for (JoinPublish joinPublish:publishes) {
            if(joinPublish.getName().equals(name)){
                quantity = joinPublish.getQuantity();
            }
        }return quantity;
    }

    public int selectQuantityPosition(String name){
        int quantity = 0;
        List<JoinPosition> joinPositions = selectAllPosition();
        for (JoinPosition joinPosition: joinPositions) {
            if(joinPosition.getName().equals(name)){
                quantity = joinPosition.getQuantity();
            }
        }return  quantity;
    }



}
