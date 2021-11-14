package controller.customerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.customer.Customer;
import model.customer.Fullname;

public class FullnameDAOImp {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String INSERT_FN_SQL = "INSERT INTO fullname" + "  (customerID, firstName, lastName) VALUES " +" (?, ?, ?);";
    private static final String SELECT_FN_BY_ID = "SELECT id, firstName, lastName from fullname where customerID =?";
    private static final String UPDATE_FN_SQL = "UPDATE fullname set firstName = ?, lastName = ? where customerID  = ?;";
    private static final String SELECT_MAX_ID = "SELECT MAX(id) FROM fullname;";

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
    
	public void createFN(Customer cus) {
		System.out.println(INSERT_FN_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FN_SQL)) {
        	preparedStatement.setInt(1, cus.getID());
            preparedStatement.setString(2, cus.getFullname().getFirstName());
            preparedStatement.setString(3, cus.getFullname().getLastName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void updatePhone(Customer cus, Fullname fn) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FN_SQL);) {
        	preparedStatement.setString(1, fn.getFirstName());
        	preparedStatement.setString(2, fn.getLastName());
        	preparedStatement.setInt(3, cus.getID());
        	System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public Fullname getFN(int ID) {
		Fullname fn = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FN_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int iD = rs.getInt("ID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                fn = new Fullname(iD, firstName, lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fn;
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
}
