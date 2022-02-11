package service.book;


import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO {


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

    private static final String SEARCH_BOOK = "SELECT books.id, books.name 'Name Of Book', a.name 'Author', books.describle 'Describe', books.language 'Language', books.status 'Status', books.type 'Type',p.name 'Publish', positions.name 'Position', books.yearPublish 'Year', books.image 'Image'\n" +
            "FROM books \n" +
            "JOIN author a ON a.id = books.idAuthor\n" +
            "JOIN publish p ON p.id = books.idPublish\n" +
            "JOIN positions ON positions.id = books.idPosition WHERE books.name like ?  ";


    private static final String SEARCH_BOOK_BY_PBL = "SELECT books.id, books.name 'Name Of Book', a.name 'Author', books.describle 'Describe', books.language 'Language', books.status 'Status', books.type 'Type',p.name 'Publish', positions.name 'Position', books.yearPublish 'Year', books.image 'Image'\n" +
            "FROM books \n" +
            "JOIN author a ON a.id = books.idAuthor\n" +
            "JOIN publish p ON p.id = books.idPublish\n" +
            "JOIN positions ON positions.id = books.idPosition WHERE p.name like ?  ";

    private static final String SORT_BOOK_BY_AUTHOR = "SELECT books.id, books.name 'Name Of Book', a.name 'Author', books.describle 'Describe', books.language 'Language', books.status 'Status', books.type 'Type',p.name 'Publish', positions.name 'Position', books.yearPublish 'Year', books.image 'Image'\n" +
            "FROM books \n" +
            "JOIN author a ON a.id = books.idAuthor\n" +
            "JOIN publish p ON p.id = books.idPublish\n" +
            "JOIN positions ON positions.id = books.idPosition WHERE a.name = ?  ";

    private static final String SORT_BOOK_BY_POSITION = "SELECT books.id, books.name 'Name Of Book', a.name 'Author', books.describle 'Describe', books.language 'Language', books.status 'Status', books.type 'Type',p.name 'Publish', positions.name 'Position', books.yearPublish 'Year', books.image 'Image'\n" +
            "FROM books \n" +
            "JOIN author a ON a.id = books.idAuthor\n" +
            "JOIN publish p ON p.id = books.idPublish\n" +
            "JOIN positions ON positions.id = books.idPosition WHERE positions.name = ?  ";

    private static final String SORT_BOOK_BY_PUBLISH = "SELECT books.id, books.name 'Name Of Book', a.name 'Author', books.describle 'Describe', books.language 'Language', books.status 'Status', books.type 'Type',p.name 'Publish', positions.name 'Position', books.yearPublish 'Year', books.image 'Image'\n" +
            "FROM books \n" +
            "JOIN author a ON a.id = books.idAuthor\n" +
            "JOIN publish p ON p.id = books.idPublish\n" +
            "JOIN positions ON positions.id = books.idPosition WHERE p.name = ?  ";

    private static final String SELECT_QUANTITY_BOOK = "SELECT quantity FROM quantityAllBook";


    public BookDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/librarymanagement1?useSSL=false";
            String jdbcUsername = "root";
            String jdbcPassword = "12345678";
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
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKS_BY_ID)) {
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
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BOOKS_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateBook(Book book, int author, int position, int publish) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKS_SQL)) {
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

    public List<Book> searchBook(String key) {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BOOK)) {
            preparedStatement.setString(1, key);
            System.out.println(preparedStatement);
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
            System.out.println(e.getMessage());
        }
        return books;
    }

    public List<Book> searchBookByPBL(String publishKey,String nameBook) {
        List<Book> books = searchBook(nameBook);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BOOK_BY_PBL)) {
            preparedStatement.setString(1, publishKey);
            System.out.println(preparedStatement);
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
            System.out.println(e.getMessage());
        }
        return books;
    }

    public List<Book> sortBookByAuthor(String nameAuthor) {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_BOOK_BY_AUTHOR)) {
            preparedStatement.setString(1, nameAuthor);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name of Book");
                String describe = rs.getString("Describe");
                String language = rs.getString("Language");
                String status = rs.getString("Status");
                String type = rs.getString("Type");
                String publish = rs.getString("Publish");
                String position = rs.getString("Position");
                String yearPublish = rs.getString("Year");
                String image = rs.getString("Image");
                books.add(new Book(id, name, nameAuthor, describe, language, status, type, publish, position, yearPublish, image));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;

    }

    public List<Book> sortBookByPosition(String namePosition) {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_BOOK_BY_POSITION)) {
            preparedStatement.setString(1, namePosition);
            System.out.println(preparedStatement);
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
                String yearPublish = rs.getString("Year");
                String image = rs.getString("Image");
                books.add(new Book(id, name, author, describe, language, status, type, publish, namePosition, yearPublish, image));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    public List<Book> sortBookByPublish(String namePublish) {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_BOOK_BY_PUBLISH)) {
            preparedStatement.setString(1, namePublish);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name of Book");
                String author = rs.getString("Author");
                String describe = rs.getString("Describe");
                String language = rs.getString("Language");
                String status = rs.getString("Status");
                String type = rs.getString("Type");
                String position = rs.getString("Position");
                String yearPublish = rs.getString("Year");
                String image = rs.getString("Image");
                books.add(new Book(id, name, author, describe, language, status, type, namePublish, position, yearPublish, image));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    public int selectQuantityAllBook(){
        int quantity = 0;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUANTITY_BOOK);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                quantity = resultSet.getInt("quantity");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }return quantity;
    }






}
