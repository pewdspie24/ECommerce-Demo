package controller.bookDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book.Book;

public class bookDAOImp implements bookDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstoremanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String SELECT_BOOK_BY_ID = "select id,title,author,years,publication, price from book where id =?";
    private static final String SELECT_ALL_BOOKS = "select * from book";
//    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update users set name = ?,gender = ?,email= ?, city =? where id = ?;";
    
    public bookDAOImp() {}
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
	public void insertBook() {
		// TODO - implement bookDAOImp.insertBook
		throw new UnsupportedOperationException();
	}

	public void deleteBook() {
		// TODO - implement bookDAOImp.deleteBook
		throw new UnsupportedOperationException();
	}

	public void updateBook() {
		// TODO - implement bookDAOImp.updateBook
		throw new UnsupportedOperationException();
	}

	public List <Book> findAllBook() {
		List < Book > books = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int years = rs.getInt("years");
                String publication = rs.getString("publication");
                float price = rs.getFloat("price");
                books.add(new Book(ID, title, author, years, publication, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
	}

	public Book findByID(int ID) {
		Book book = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                int years = rs.getInt("years");
                String publication = rs.getString("publication");
                float price = rs.getFloat("price");
                book = new Book(ID, title, author, years, publication, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
	}

}