package controller.bookitemDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.bookDAO.bookDAOImp;
import controller.cartDAO.cartDAOImp;
import model.book.Book;
import model.bookitem.Bookitem;
import model.cart.Cart;

public class bookitemDAOImp implements bookitemDAO{
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstoremanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String INSERT_BITEM_SQL = "INSERT INTO bookitem" + "  (bookID, cartID, numbers, totalPrice) VALUES " +" (?, ?, ?, ?);";
    private static final String SELECT_BITEM_BY_CID = "select * from bookitem where cartID = ? and bookID = ?";
    private static final String SELECT_NUM_BY_CID = "select numbers from bookitem where cartID = ? and bookID = ?";
    private static final String DELETE_BITEM_BY_CID_SQL = "delete from bookitem where cartID  = ?;";
    private static final String UPDATE_BITEM_SQL = "UPDATE bookitem SET numbers= ? WHERE bookID = ? and cartID = ?;";
    private static final String SELECT_ALL_BITEM_BY_CID = "select * from bookitem where cartID = ?";
    
    
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
    
	public void insertBookItem(Bookitem bki) {
		System.out.println(INSERT_BITEM_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BITEM_SQL)) {
            preparedStatement.setInt(1, bki.getBook().getID());
            preparedStatement.setInt(2, bki.getCart().getID());
            preparedStatement.setInt(3, bki.getNumbers());
            preparedStatement.setFloat(4, bki.getTotalPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public boolean deleteBookitem(int id){
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BITEM_BY_CID_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rowDeleted;
    }
	
	public List <Bookitem> findAllBookitem(int customerID){
		List < Bookitem > books = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BITEM_BY_CID);) {
        	preparedStatement.setInt(1, customerID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int bookID = rs.getInt("BookID");
                int cartID = rs.getInt("CartID");
                int numbers = rs.getInt("Numbers");
                float totalPrice = rs.getFloat("totalPrice");
                bookDAOImp bookdao = new bookDAOImp();
                cartDAOImp cartdao = new cartDAOImp();
                Book book = bookdao.findByID(bookID);
                Cart cart = cartdao.findCart(customerID);
                Bookitem bookitem = new Bookitem(ID, book, cart, numbers, totalPrice);
                books.add(bookitem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
	}
	public boolean checkItem(int cartID, int bookID){
		boolean status = false;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BITEM_BY_CID)) {
            preparedStatement.setInt(1, cartID);
            preparedStatement.setInt(2, bookID);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return status;
	}
	
	public int getNum(int cartID, int bookID){
		int numbers = 0;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NUM_BY_CID)) {
            preparedStatement.setInt(1, cartID);
            preparedStatement.setInt(2, bookID);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
            	numbers = rs.getInt("numbers");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return numbers;
	}
	
	public void updateBookItem(Bookitem bki, int numbers){
		System.out.println(UPDATE_BITEM_SQL);
		int prevNum = getNum(bki.getCart().getID(), bki.getBook().getID());
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BITEM_SQL)) {
            preparedStatement.setInt(1, prevNum+numbers);
            preparedStatement.setInt(2, bki.getBook().getID());
            preparedStatement.setInt(3, bki.getCart().getID());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
