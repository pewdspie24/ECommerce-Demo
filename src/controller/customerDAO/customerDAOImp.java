package controller.customerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;

public class customerDAOImp implements customerDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstoremanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String INSERT_CUS_SQL = "INSERT INTO customer" + "  (accountID, addressID, Name, Gender, Age, PhoneNum, Email, AccountNum) VALUES " +" (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CUS_BY_ID = "select ID, accountID, addressID, Name, Gender, Age, PhoneNum, Email, AccountNum from customer where ID =?";
    private static final String SELECT_ADD_BY_ID = "select ID, City, District, HouseNo from address where ID =?";
    private static final String SELECT_ACC_BY_ID = "select id,username,password from account where id =?";
    private static final String SELECT_CUS_BY_ACC_ID = "select * from customer where accountID =?";
    private static final String SELECT_MAX_ID = "SELECT MAX(id) FROM customer;";
    
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
    
	public void updateCustomer(Customer customer) {
		System.out.println(INSERT_CUS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUS_SQL)) {
            preparedStatement.setInt(1, customer.getAccount().getID());
            preparedStatement.setInt(2, customer.getAddress().getID());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getGender());
            preparedStatement.setInt(5, customer.getAge());
            preparedStatement.setString(6, customer.getPhoneNum());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAccountNum());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void findAllCustomer() {
		// TODO - implement customerDAOImp.findAllCustomer
		throw new UnsupportedOperationException();
	}

	public void findByID() {
		// TODO - implement customerDAOImp.findByID
		throw new UnsupportedOperationException();
	}

	public Customer viewCustomer(int ID) {
		Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUS_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int	accountID = rs.getInt("AccountID");
            	Account account = getAccount(accountID);
            	int	addressID = rs.getInt("AddressID");
            	Address address = getAddress(addressID);
                String name = rs.getString("Name");
                String gender = rs.getString("Gender");
                int age = rs.getInt("Age");
                String phoneNum = rs.getString("PhoneNum");
                String email = rs.getString("Email");
                String accountNum = rs.getString("AccountNum");
                customer = new Customer(ID, name, gender, age, address, account, phoneNum, email, accountNum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
	}

	@Override
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
                String username = rs.getString("username");
                String password = rs.getString("password");
                acc = new Account(ID, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
	}

	@Override
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
	
	public int getCusID(int accountID){
		int ID = 0;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUS_BY_ACC_ID)) {
            preparedStatement.setInt(1, accountID);
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