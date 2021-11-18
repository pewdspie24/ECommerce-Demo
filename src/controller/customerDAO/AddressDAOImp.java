package controller.customerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.customer.Address;
import model.customer.Customer;

public class AddressDAOImp implements AddressDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String INSERT_ADD_SQL = "INSERT INTO address" + "  ( number, city, district, street) VALUES " +" (?, ?, ?, ?);";
    private static final String SELECT_ADD_BY_ID = "select id, number, city, district, street from address where ID =?";
    private static final String DELETE_ADD_SQL = "delete from address where ID  = ?;";
    private static final String SELECT_MAX_ID = "SELECT MAX(id) FROM address;";

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
    
	public void insertAddress(Address address) {
		System.out.println(INSERT_ADD_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADD_SQL)) {
        	preparedStatement.setInt(1, cus.getID());
        	preparedStatement.setString(2, address.getNumber());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getDistrict());
            preparedStatement.setString(5, address.getStreet());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public boolean deleteAddress(int ID) {
		boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ADD_SQL);) {
            statement.setInt(1, ID);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
	}

	public Address getAddress(int ID) {
		Address add = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADD_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int iD = rs.getInt("ID");
                String number = rs.getString("number");
                String city = rs.getString("city");
                String district = rs.getString("district");
                String street = rs.getString("street");
                add = new Address(ID, number, street, district, city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return add;
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
