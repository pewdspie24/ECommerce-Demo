package controller.customerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.Fullname;
import model.customer.Phone;

public class CustomerDAOImp implements CustomerDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_CUS_SQL = "INSERT INTO customer"
            + "  (gender, birth, accountnum, ID3, CardID, Date2, ID2, Date, accountID, addressID, phoneID, fullnameID, id) VALUES "
            + " (?, ?, ?, NULL, NULL, NULL, NULL, NULL, ?, ?, ?, ?, ?);";
    private static final String SELECT_CUS_BY_ID = "select * from customer where ID =?";
    private static final String SELECT_ADD_BY_ID = "select id, number, city, district, street from address where ID =?";
    private static final String SELECT_ACC_BY_ID = "select id,email,password,createdat from account where ID =?";
    private static final String SELECT_PHO_BY_ID = "SELECT id, number, city, district, street from phone where ID =?";
    private static final String SELECT_FN_BY_ID = "SELECT id, firstName, lastName from fullname where ID =?";
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

    public void insertCustomer(Customer customer) {
        System.out.println(INSERT_CUS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUS_SQL)) {
                    // gender, birth, accountnum, ID3, CardID, Date2, ID2, Date, accountID,
                    // addressID, phoneID, fullnameID, id
            preparedStatement.setString(1, customer.getGender());
            preparedStatement.setString(2, customer.getBirth());
            preparedStatement.setString(3, customer.getAccountNum());
            preparedStatement.setInt(4, customer.getAccount().getID());
            preparedStatement.setInt(5, customer.getAddress().getID());
            preparedStatement.setInt(6, customer.getPhone().getID());
            preparedStatement.setInt(7, customer.getFullname().getID());
            preparedStatement.setInt(8, customer.getID());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findAllCustomer() {
        throw new UnsupportedOperationException();
    }

    public void findByID() {
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
                String gender = rs.getString("gender");
                String birth = rs.getString("birth");
                String accountNum = rs.getString("accountnum");
                int accountID = rs.getInt("accountID");
                int addressID = rs.getInt("addressID");
                int phoneID = rs.getInt("phoneID");
                int fullnameID = rs.getInt("fullnameID");
                Account account = getAccount(accountID);
                Address address = getAddress(addressID);
                Phone phone = getPhone(phoneID);
                Fullname fullname = getFullName(fullnameID);
                customer = new Customer(ID, accountNum, gender, birth, account, fullname, phone, address);
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
                int iD = rs.getInt("ID");
                String number = rs.getString("number");
                String city = rs.getString("city");
                String district = rs.getString("district");
                String street = rs.getString("street");
                add = new Address(iD, number, street, district, city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return add;
    }

    public Fullname getFullName(int ID) {
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

    public int getCustomerID(int accountID) {
        int ID = 0;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUS_BY_ACC_ID)) {
            preparedStatement.setInt(1, accountID);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ID = rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ID;
    }

    public int getMaxID() {
        int id = 0;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MAX_ID)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("MAX(id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
