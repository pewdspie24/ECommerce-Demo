package controller.addressDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.customer.Address;

public class addressDAOImp implements addressDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstoremanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String INSERT_ADD_SQL = "INSERT INTO address" + "  (City, District, HouseNo) VALUES " +" (?, ?, ?);";
    private static final String SELECT_ADD_BY_ID = "select ID, City, District, HouseNo from address where ID =?";
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
    
	public void insertAddress(Address add) {
		System.out.println(INSERT_ADD_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADD_SQL)) {
            preparedStatement.setString(1, add.getCity());
            preparedStatement.setString(2, add.getDistrict());
            preparedStatement.setInt(3, add.getHouseNo());
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
                String city = rs.getString("City");
                String district = rs.getString("District");
                int houseNo = rs.getInt("HouseNo");
                add = new Address(ID, city, district , houseNo);
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