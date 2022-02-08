package service.book;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/librarymanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";


    private static final String INSERT_BOOKS_SQL = "INSERT INTO books_list (name, authorID, describe, language, status, type, publishID, positionID, yearPublish, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_BOOKS_BY_ID = "select * from books_list where id =?";
    private static final String SELECT_ALL_BOOKS = "SELECT * from books_list";
    private static final String DELETE_BOOKS_SQL = "delete from books_list where id = ?;";
    private static final String UPDATE_BOOKS_SQL = "update books_list set name = ?,authorID= ?, describe =?, language=?, status=?, type=?, publishID=?,positionID=?,yearPublish=?,image=?  WHERE id = ?;";

    public BookDAO(){}

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
    public void insertBook(Book book) throws SQLException {
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthorID());
            preparedStatement.setString(3, book.getDescribe());
            preparedStatement.setString(4, book.getLanguage());
            preparedStatement.setString(5, book.getStatus());
            preparedStatement.setString(6, book.getType());
            preparedStatement.setString(7, book.getPublish());
            preparedStatement.setString(8, book.getPositionID());
            preparedStatement.setString(9, book.getYearPublish());
            preparedStatement.setString(10, book.getImage());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Book selectBook(int id) {
        return null;
    }

    @Override
    public List<Book> selectAllBook() {
        List<Book> books = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
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

        }catch (SQLException e){
            e.printStackTrace();
        }return books;
    }

    @Override
    public boolean deleteBook(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateBook(Book book) throws SQLException {
        return false;
    }
}
