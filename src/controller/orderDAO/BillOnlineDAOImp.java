package controller.orderDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.customerDAO.CustomerDAOImp;
import model.customer.Customer;
import model.order.BillOnline;
import model.order.Cart;
import model.order.Order;
import model.order.Payment;

public class BillOnlineDAOImp implements BillOnlineDAO{
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
	private static final String SELECT_BILL_BY_ID = "select * from billonline where id =?";
    private static final String SELECT_ALL_BILLS = "select * from billonline";
    private static final String INSERT_BILL_SQL = "INSERT INTO billonline" + "  (customerID, orderID, totalPrice, dateCreate, totalDiscount) VALUES " +" (?, ?, ?, ?, ?);";
    private static final String SELECT_MAX_ID = "SELECT MAX(id) FROM billonline;";
    
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
    
    
	public void insertBill(BillOnline bill) {
		System.out.println(INSERT_BILL_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BILL_SQL)) {
        	preparedStatement.setInt(1, bill.getCustomer().getID());
            preparedStatement.setInt(2, bill.getOrder().getID());
            preparedStatement.setFloat(3, bill.getTotalPrice());
            preparedStatement.setString(4, bill.getDateCreate());
            preparedStatement.setFloat(5, bill.getTotalDiscount());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public BillOnline getBill(int ID) {
		BillOnline bill = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BILL_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int customerID = rs.getInt("CustomerID");
                int orderID = rs.getInt("orderID");
                float totalPrice = rs.getFloat("totalPrice");
                String dateCreate = rs.getString("DateCreate");
                float totalDiscount = rs.getFloat("totalDiscount");
                CustomerDAOImp cusdao = new CustomerDAOImp();
                OrderDAOImp orderdao = new OrderDAOImp();
                Customer customer = cusdao.viewCustomer(customerID);
                Order order = orderdao.getOrder(orderID);
                bill = new BillOnline(ID, customer, order, totalPrice, dateCreate, totalDiscount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bill;
	}
	
	public List <BillOnline> findAllBill() {
		List <BillOnline> bill = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BILLS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
            	int customerID = rs.getInt("CustomerID");
                int orderID = rs.getInt("orderID");
                float totalPrice = rs.getFloat("totalPrice");
                String dateCreate = rs.getString("DateCreate");
                float totalDiscount = rs.getFloat("totalDiscount");
                CustomerDAOImp cusdao = new CustomerDAOImp();
                OrderDAOImp orderdao = new OrderDAOImp();
                Customer customer = cusdao.viewCustomer(customerID);
                Order order = orderdao.getOrder(orderID);
                bill.add(new BillOnline(ID, customer, order, totalPrice, dateCreate, totalDiscount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bill;
	}
}
