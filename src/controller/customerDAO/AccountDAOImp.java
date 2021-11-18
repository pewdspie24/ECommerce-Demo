package controller.customerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.customer.Account;
import model.customer.Customer;

public class AccountDAOImp implements AccountDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String INSERT_ACC_SQL = "INSERT INTO account" + "  (email, password, createat) VALUES " +" (?, ?, ?);";
    private static final String SELECT_ACC_BY_ID = "select id,email,password,createdat from account where ID =?";
    private static final String VALIDATE_ACC_BY_USR_PWD = "select * from account where email = ? and password = ? ";
    private static final String SELECT_MAX_ID = "SELECT MAX(id) FROM account;";

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
	
	public void createAccount(Account acc) {
		System.out.println(INSERT_ACC_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACC_SQL)) {
        	preparedStatement.setInt(1, acc.getID());
        	preparedStatement.setString(2, acc.getEmail());
            preparedStatement.setString(3, acc.getPassword());
            preparedStatement.setString(4, acc.getCreatedAt());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public Account getAccount(int ID) {
		Account acc = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACC_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int iD = rs.getInt("ID");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String createdAt = rs.getString("createdat");
                acc = new Account(iD, email, password, createdAt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
	}

	public boolean validateAccount(String email, String password){
		boolean status = false;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_ACC_BY_USR_PWD)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return status;
	}
	
	public int getAccID(String email, String password){
		int ID = 0;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_ACC_BY_USR_PWD)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
            	ID = rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return ID;
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
