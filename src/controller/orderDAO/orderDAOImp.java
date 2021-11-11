package controller.orderDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.cartDAO.cartDAOImp;
import controller.customerDAO.customerDAOImp;
import controller.paymentDAO.paymentDAOImp;
import controller.shipmentDAO.shipmentDAOImp;
import model.cart.Cart;
import model.customer.Customer;
import model.order.Order;
import model.payment.Payment;
import model.shipment.Shipment;

public class orderDAOImp implements orderDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstoremanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
	private static final String SELECT_ORDER_BY_ID = "select id,cartID,shipmentID,paymentID,customerID,totalPrice,totalDiscount,dateTime from `order` where id =?";
    private static final String SELECT_ALL_ORDERS = "select * from `order`";
    private static final String INSERT_ORDER_SQL = "INSERT INTO `order`" + "  (cartID, shipmentID, paymentID, customerID, totalPrice, totalDiscount, datetime) VALUES " +" (?, ?, ?, ?, ?, ?, ?);";
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
            preparedStatement.setInt(2, ord.getShipment().getID());
            preparedStatement.setInt(3, ord.getPayment().getID());
            preparedStatement.setInt(4, ord.getCustomer().getID());
            preparedStatement.setFloat(5, ord.getTotalPrice());
            preparedStatement.setInt(6, ord.getTotalDiscount());
            preparedStatement.setString(7, ord.getDateTime());
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
                int shipmentID = rs.getInt("ShipmentID");
                int paymentID = rs.getInt("PaymentID");
                int customerID = rs.getInt("CustomerID");
                float totalPrice = rs.getFloat("TotalPrice");
                int totalDiscount = rs.getInt("TotalDiscount");
                String dateTime = rs.getString("DateTime");
                customerDAOImp cusdao = new customerDAOImp();
                shipmentDAOImp shipdao = new shipmentDAOImp();
                cartDAOImp cartdao = new cartDAOImp();
                paymentDAOImp paydao = new paymentDAOImp();
                Customer customer = cusdao.viewCustomer(customerID);
                Cart cart = cartdao.findCart(customerID);
                Shipment shipment = shipdao.selectShipment(shipmentID);
                Payment payment = paydao.selectPayment(paymentID);
                order = new Order(customerID, customer, cart, shipment, payment, totalPrice, totalDiscount, dateTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
	}
	
	public void findAllOrder() {
		// TODO - implement orderDAOImp.findAllOrder
		throw new UnsupportedOperationException();
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