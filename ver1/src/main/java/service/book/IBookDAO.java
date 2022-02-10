package service.book;

import model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookDAO {
    void insertBook(Book book, int author, int position, int publish) throws SQLException;

     Book selectBook(int id);

     List<Book> selectAllBook();

     boolean deleteBook(int id) throws SQLException;

     boolean updateBook(Book book, int author, int position, int publish) throws SQLException;
}
