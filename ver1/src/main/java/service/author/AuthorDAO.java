package service.author;

import model.Author;
import service.InterfaceDAO;

import java.sql.SQLException;
import java.util.List;

public class AuthorDAO implements InterfaceDAO<Author> {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_AUTHORS_SQL = "INSERT INTO authors (name, address, email) VALUES (?, ?, ?);";
    private static final String SELECT_AUTHORS_BY_ID = "select id,name,address,email from authors where id =?";
    private static final String SELECT_ALL_AUTHORS = "select * from authors";
    private static final String DELETE_AUTHORS_SQL = "delete from authors where id = ?;";
    private static final String UPDATE_AUTHORS_SQL = "update authors set name = ?,address= ?, email =? where id = ?;";


    @Override
    public void insert(Author author) throws SQLException {

    }

    @Override
    public Author select(int id) {
        return null;
    }

    @Override
    public List<Author> selectAll() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Author author) throws SQLException {
        return false;
    }
}
