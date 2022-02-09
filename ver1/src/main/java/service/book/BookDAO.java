package service.book;

import model.Author;
import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/librarymanagement1?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";


    private static final String INSERT_BOOKS_SQL = "INSERT INTO books(name, describle, language, status, type, image, yearPublish, idPublish, idAuthor, idPosition) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_BOOKS_BY_ID = "SELECT books.id, books.name 'Name Of Book', a.name 'Author', books.describle 'Describe', books.language 'Language', books.status 'Status', books.type 'Type',p.name 'Publish', positions.name 'Position', books.yearPublish 'Year', books.image 'Image'\n" +
            "FROM books \n" +
            "JOIN author a ON a.id = books.idAuthor\n" +
            "JOIN publish p ON p.id = books.idPublish\n" +
            "JOIN positions ON positions.id = books.idPosition WHERE books.id=?;";


    private static final String SELECT_ALL_BOOKS = "SELECT books.id, books.name 'Name Of Book', a.name 'Author', books.describle 'Describe', books.language 'Language', books.status 'Status', books.type 'Type',p.name 'Publish', positions.name 'Position', books.yearPublish 'Year', books.image 'Image'\n" +
            "FROM books \n" +
            "JOIN author a ON a.id = books.idAuthor\n" +
            "JOIN publish p ON p.id = books.idPublish\n" +
            "JOIN positions ON positions.id = books.idPosition;";
    private static final String DELETE_BOOKS_SQL = "delete from books where id = ?;";
    private static final String UPDATE_BOOKS_SQL = "update books set name = ?,describle= ?, language =?, status=?, type=?, image=?, yearPublish=?,idPublish=?,idAuthor=?,idPosition=?  WHERE id = ?;";



    public BookDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    @Override
    public void insertBook(Book book, int author, int position, int publish) throws SQLException {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getDescribe());
            preparedStatement.setString(3, book.getLanguage());
            preparedStatement.setString(4, book.getStatus());
            preparedStatement.setString(5, book.getType());
            preparedStatement.setString(6, book.getImage());
            preparedStatement.setString(7, book.getYearPublish());
            preparedStatement.setInt(8, publish);
            preparedStatement.setInt(9, author);
            preparedStatement.setInt(10, position);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Book selectBook(int id) {
        Book book = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Name of Book");
                String author = rs.getString("Author");
                String describe = rs.getString("Describe");
                String language = rs.getString("Language");
                String status = rs.getString("Status");
                String type = rs.getString("Type");
                String publish = rs.getString("Publish");
                String position = rs.getString("Position");
                String yearPublish = rs.getString("Year");
                String image = rs.getString("Image");
                book = new Book(id, name, author, describe, language, status, type, publish, position, yearPublish, image);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    @Override
    public List<Book> selectAllBook() {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name of Book");
                String author = rs.getString("Author");
                String describe = rs.getString("Describe");
                String language = rs.getString("Language");
                String status = rs.getString("Status");
                String type = rs.getString("Type");
                String publish = rs.getString("Publish");
                String position = rs.getString("Position");
                String yearPublish = rs.getString("Year");
                String image = rs.getString("Image");
                books.add(new Book(id, name, author, describe, language, status, type, publish, position, yearPublish, image));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public boolean deleteBook(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BOOKS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateBook(Book book, int author, int position, int publish) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKS_SQL);) {
            statement.setString(1, book.getName());
            statement.setString(2, book.getDescribe());
            statement.setString(3, book.getLanguage());
            statement.setString(4, book.getStatus());
            statement.setString(5, book.getType());
            statement.setString(6, book.getImage());
            statement.setString(7, book.getYearPublish());
            statement.setInt(8,publish);
            statement.setInt(9, author);
            statement.setInt(10, position);
            statement.setInt(11, book.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
