package controller.customerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.customer.Customer;
import model.customer.Phone;

public class PhoneDAOImp implements PhoneDAO{
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String INSERT_PHO_SQL = "INSERT INTO PHONE" + "  (customerID, statesNo, number) VALUES " +" (?, ?, ?);";
    private static final String SELECT_PHO_BY_ID = "SELECT id, number, city, district, street from phone where customerID =?";
    private static final String UPDATE_PHO_SQL = "UPDATE phone set statesno = ?, number = ? where customerID  = ?;";
    private static final String SELECT_MAX_ID = "SELECT MAX(id) FROM phone;";

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
    
	public void createPhone(Customer cus) {
		System.out.println(INSERT_PHO_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADD_SQL)) {
        	preparedStatement.setInt(1, cus.getID());
            preparedStatement.setString(2, cus.getPhone().getStatesNo());
            preparedStatement.setString(3, cus.getPhone().getNumber());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void updatePhone(Customer cus, Phone pho) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PHO_SQL);) {
        	preparedStatement.setString(1, pho.getStatesNo());
        	preparedStatement.setString(2, pho.getNumber());
        	preparedStatement.setInt(3, cus.getID());
        	System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public Phone getPhone(int ID) {
		Phone pho = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PHO_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int iD = rs.getInt("ID");
                String statesNo = rs.getString("StatesNo");
                String number = rs.getString("Number");
                pho = new Phone(iD, statesNo, number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pho;
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
