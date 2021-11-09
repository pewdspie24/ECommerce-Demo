package controller.cartDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.customerDAO.customerDAOImp;
import model.cart.Cart;
import model.customer.Customer;

public class cartDAOImp implements cartDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstoremanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String INSERT_CART_SQL = "INSERT INTO cart" + "  (customerID, cartPrice,  totalDiscount) VALUES " +" (?, ?, ?);";
    private static final String UPDATE_CART_BY_ID = "UPDATE cart SET cartPrice= ? WHERE ID = ?;";
    private static final String DELETE_BITEM_SQL = "delete from cart where ID  = ?;";
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
    
    public boolean deleteCart(int id){
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BITEM_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rowDeleted;
    }
    
    public void createCart(Cart cart){
    	System.out.println(INSERT_CART_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_SQL)) {
            preparedStatement.setInt(1, cart.getCustomer().getID());
            preparedStatement.setFloat(2, cart.getCartPrice());
            preparedStatement.setInt(3, cart.getTotalDiscount());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	public void updateCart(Cart cart, float price) {
		System.out.println(UPDATE_CART_BY_ID);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_BY_ID)) {
            preparedStatement.setFloat(1, price);
            preparedStatement.setInt(2, cart.getID());
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
                Float cartPrice = rs.getFloat("cartPrice");
                int totalDiscount = rs.getInt("totalDiscount");
                customerDAOImp cusdao = new customerDAOImp();
                Customer customer = cusdao.viewCustomer(customerID);
                cart = new Cart(ID, customer, cartPrice, totalDiscount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
	}

}