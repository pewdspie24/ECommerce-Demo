package controller.orderDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.customerDAO.CustomerDAOImp;
import controller.orderDAO.PaymentDAOImp;
import model.customer.Customer;
import model.order.Cart;
import model.order.Order;
import model.order.Payment;

public class OrderDAOImp implements OrderDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
	private static final String SELECT_ORDER_BY_ID = "select * from `order` where id =?";
    private static final String SELECT_ALL_ORDERS = "select * from `order`";
    private static final String INSERT_ORDER_SQL = "INSERT INTO `order`" + "  (cartID, paymentID, customerID, date) VALUES " +" (?, ?, ?, ?);";
    private static final String SELECT_MAX_ID = "SELECT MAX(id) FROM `order`;";
    
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
    
    public int getMaxID(){
		int id = 0;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MAX_ID)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
            	id = rs.getInt("MAX(id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return id;
	}
    
	public void insertOrder(Order ord) {
		System.out.println(INSERT_ORDER_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {
        	preparedStatement.setInt(1, ord.getCart().getID());
            preparedStatement.setInt(2, ord.getPayment().getID());
            preparedStatement.setInt(3, ord.getCustomer().getID());
            preparedStatement.setString(4, ord.getDate());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public Order getOrder(int ID) {
		Order order = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int cardID = rs.getInt("CartID");
                int paymentID = rs.getInt("PaymentID");
                int customerID = rs.getInt("CustomerID");
                String date = rs.getString("Date");
                CustomerDAOImp cusdao = new CustomerDAOImp();
                CartDAOImp cartdao = new CartDAOImp();
                PaymentDAOImp paydao = new PaymentDAOImp();
                Customer customer = cusdao.viewCustomer(customerID);
                Cart cart = cartdao.findCart(customerID);
                Payment payment = paydao.getPaymentByID(paymentID);
                order = new Order(ID, cart, payment, customer, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
	}
	
	public List <Order> findAllOrder() {
		List <Order> order = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                int cardID = rs.getInt("CartID");
                int paymentID = rs.getInt("PaymentID");
                int customerID = rs.getInt("CustomerID");
                String date = rs.getString("Date");
                CustomerDAOImp cusdao = new CustomerDAOImp();
                CartDAOImp cartdao = new CartDAOImp();
                PaymentDAOImp paydao = new PaymentDAOImp();
                Customer customer = cusdao.viewCustomer(customerID);
                Cart cart = cartdao.findCart(customerID);
                Payment payment = paydao.getPaymentByID(paymentID);
                order.add(new Order(ID, cart, payment, customer, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
	}

	public void getShipment() {
		// TODO - implement orderDAOImp.getShipment
		throw new UnsupportedOperationException();
	}

	public void getPayment() {
		// TODO - implement orderDAOImp.getPayment
		throw new UnsupportedOperationException();
	}

	public void getCart() {
		// TODO - implement orderDAOImp.getCart
		throw new UnsupportedOperationException();
	}

	public void viewCustomer() {
		// TODO - implement orderDAOImp.viewCustomer
		throw new UnsupportedOperationException();
	}

}