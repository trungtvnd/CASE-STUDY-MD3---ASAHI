package service.book;

import model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookDAO {
    public void insertBook(Book book) throws SQLException;

    public Book selectBook(int id);

    public List<Book> selectAllBook();

    public boolean deleteBook(int id) throws SQLException;

    public boolean updateBook(Book book) throws SQLException;
}
