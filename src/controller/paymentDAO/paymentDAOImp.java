package controller.paymentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book.Book;
import model.payment.Payment;

public class PaymentDAOImp implements PaymentDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstoremanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
//    private static final String INSERT_PM_SQL = "INSERT INTO cart" + "  (customerID, cartPrice,  totalDiscount) VALUES " +" (?, ?, ?);";
//    private static final String UPDATE_PM_BY_ID = "UPDATE cart SET cartPrice= ? WHERE ID = ?;";
//    private static final String DELETE_PM_SQL = "delete from cart where ID  = ?;";
    private static final String SELECT_PM_BY_ID = "select id,methodName,discount from payment where ID =?";
    private static final String SELECT_ALL_PM_BY_ID = "select * from payment";
    
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
	public void insertPaymentMethod() {
		// TODO - implement paymentDAOImp.insertPaymentMethod
		throw new UnsupportedOperationException();
	}

	public void deletePaymentMethod() {
		// TODO - implement paymentDAOImp.deletePaymentMethod
		throw new UnsupportedOperationException();
	}

	public void updatePaymentMethod() {
		// TODO - implement paymentDAOImp.updatePaymentMethod
		throw new UnsupportedOperationException();
	}

	public List <Payment> findAllPayment() {
		List < Payment > payments = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PM_BY_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                String methodName = rs.getString("methodName");
                int discount = rs.getInt("discount");
                Payment payment = new Payment(ID, methodName, discount);
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
	}

	public Payment selectPayment(int ID) {
		Payment payment = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PM_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String methodName = rs.getString("methodName");
                int discount = rs.getInt("discount");
                payment = new Payment(ID, methodName, discount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
	}

}