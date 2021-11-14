package controller.orderDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.customerDAO.customerDAOImp;
import model.book.*;
import model.clothes.*;
import model.customer.Customer;
import model.electronic.ElectronicItem;
import model.order.Cart;
import model.shoes.*;

public class CartDAOImp implements CartDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstoremanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String INSERT_CART_SQL = "INSERT INTO cart" + "  (customerID, createdAt, updatedAt, totalQuantity, totalPrice) VALUES " +" (?, ?, ?, ?, ?);";
    private static final String UPDATE_CART_BY_ID = "UPDATE cart SET totalPrice= ? AND totalQuantity = ? WHERE ID = ?;";
    private static final String SELECT_CART_BY_ID = "select id,customerID,cartPrice,totalDiscount from cart where customerID =?";
    
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

	/**
	 * 
	 * @param book
	 */
	public void addBookitem(BookItem book) {
		// TODO - implement CartDAOImp.addBookitem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param electronics
	 */
	public void addElectronicItem(ElectronicItem electronic) {
		// TODO - implement CartDAOImp.addElectronicItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param clothes
	 */
	public void addClothesItem(ClothesItem clothes) {
		// TODO - implement CartDAOImp.addClothesItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param shoes
	 */
	public void addShoesItem(ShoesItem shoes) {
		// TODO - implement CartDAOImp.addShoesItem
		throw new UnsupportedOperationException();
	}
	
	public void createCart(Cart cart){
    	System.out.println(INSERT_CART_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_SQL)) {
            preparedStatement.setInt(1, cart.getCustomer().getID());
            preparedStatement.setString(2, cart.getCreatedAt());
            preparedStatement.setString(3, cart.getUpdatedAt());
            preparedStatement.setInt(4, cart.getTotalQuantity());
            preparedStatement.setFloat(4, cart.getTotalPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	public void updateCart(Cart cart, float price, int quantity) {
		System.out.println(UPDATE_CART_BY_ID);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_BY_ID)) {
            preparedStatement.setFloat(1, price);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(3, cart.getID());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public Cart findCart(int customerID) {
		Cart cart = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_ID);) {
            preparedStatement.setInt(1, customerID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String createdAt = rs.getString("createdAt");
                String updatedAt= rs.getString("updatedAt");
                Float totalPrice = rs.getFloat("totalPrice");
                int totalQuantity = rs.getInt("totalQuantity");
                customerDAOImp cusdao = new customerDAOImp();
                Customer customer = cusdao.viewCustomer(customerID);
                cart = new Cart(ID, customer, createdAt, updatedAt, totalQuantity, totalPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
	}
}