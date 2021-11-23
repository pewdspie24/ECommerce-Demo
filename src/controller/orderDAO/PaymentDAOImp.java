package controller.orderDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.order.Cash;
import model.order.Check;
import model.order.Credit;
import model.order.Payment;
import model.order.Shipment;
import model.order.Voucher;

public class PaymentDAOImp implements PaymentDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String SELECT_CASH_BY_ID = "select * from payment where id =?;";
    private static final String SELECT_CHECKS_BY_ID = "select * from payment where id =?;";
    private static final String SELECT_CREDIT_BY_ID = "select * from payment where id =?;";
    private static final String CHECK_TYPES_CASHS = "select * from payment where id =? and id2 is not null;";
    private static final String CHECK_TYPES_CHECKS = "select * from payment where id =? and id3 is not null;";
    private static final String CHECK_TYPES_CREDITS = "select * from payment where id =? and id4 is not null;";
    private static final String SELECT_ALL_CASHS = "select * from payment where id2 is not null;";
    private static final String SELECT_ALL_CHECKS = "select * from payment where id3 is not null;";
    private static final String SELECT_ALL_CREDITS = "select * from payment where id4 is not null;";
    private static final String SELECT_SHIPMENT_BY_ID = "select * from Shipment where id =?;";
    private static final String SELECT_VOUCHER_BY_ID = "select * from Voucher where id =?;";
    private static final String SELECT_PAYMENT_BY_ID = "select * from payment where id =?;";

	public void getShipment() {
		// TODO - implement PaymentDAOImp.getShipment
		throw new UnsupportedOperationException();
	}

	public void createPayment() {
		// TODO - implement PaymentDAOImp.createPayment
		throw new UnsupportedOperationException();
	}

	public void updatePayment() {
		// TODO - implement PaymentDAOImp.updatePayment
		throw new UnsupportedOperationException();
	}
	
	public PaymentDAOImp() {}
	
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
	
	public Payment getPaymentByID(int ID) {
		Payment pay = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENT_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int iD = rs.getInt("ID");
                float amount = rs.getFloat("amount");
                int shipmentID = rs.getInt("shipmentID");
                int voucherID = rs.getInt("voucherID");
                Shipment shipment = getShipmentByID(shipmentID);
                Voucher voucher = getVoucherByID(voucherID);
                pay = new Payment(iD, amount, shipment, voucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pay;
	}
	
	public Shipment getShipmentByID(int ID) {
		Shipment man = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHIPMENT_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int iD = rs.getInt("ID");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                man = new Shipment(iD, price, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return man;
	}
	
	public Voucher getVoucherByID(int ID) {
		Voucher man = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VOUCHER_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int iD = rs.getInt("ID");
                String name = rs.getString("name");
                String expiresDate = rs.getString("expiresDate");
                man = new Voucher(iD, name, expiresDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return man;
	}
	
	public List <Check> findAllCheck() {
		List < Check > checks = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CHECKS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int shipID = rs.getInt("ShipmentID");
                int vouID = rs.getInt("VoucherID");
                Shipment shipment = getShipmentByID(shipID);
                Voucher voucher = getVoucherByID(vouID);
                int amount = rs.getInt("amount");
                int iD2 = rs.getInt("ID3");
                String name = rs.getString("name");
                String bankID = rs.getString("bankID");
                checks.add(new Check(ID, amount, shipment, voucher, iD2, name, bankID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checks;
	}
	
	public List <Cash> findAllCash() {
		List < Cash > cashs = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CASHS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                int shipID = rs.getInt("ShipmentID");
                int vouID = rs.getInt("VoucherID");
                Shipment shipment = getShipmentByID(shipID);
                Voucher voucher = getVoucherByID(vouID);
                int amount = rs.getInt("amount");
                int iD2 = rs.getInt("ID2");
                float cashTendered = rs.getFloat("cashTendered");
                cashs.add(new Cash(ID, amount, shipment, voucher, iD2, cashTendered));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cashs;
	}
	
	public List <Credit> findAllCredit() {
		List < Credit > credits = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CREDITS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                int shipID = rs.getInt("ShipmentID");
                int vouID = rs.getInt("VoucherID");
                Shipment shipment = getShipmentByID(shipID);
                Voucher voucher = getVoucherByID(vouID);
                int amount = rs.getInt("amount");
                int iD2 = rs.getInt("ID4");
                String number = rs.getString("number");
                String type = rs.getString("type");
                String expString = rs.getString("expString");
                credits.add(new Credit(ID, amount, shipment, voucher, iD2, number, type, expString));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credits;
	}
	
	public int checkType(int ID){
		int flag = 0;
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_CASHS);) {
            statement.setInt(1, ID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
            	flag = 2;
            	return flag;
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_CHECKS);) {
            statement.setInt(1, ID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
            	flag = 3;
            	return flag;
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_CREDITS);) {
            statement.setInt(1, ID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
            	flag = 4;
            	return flag;
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public Cash findCashByID(int ID) {
		Cash cash = null;
        // Step 1: Establishing a Connection
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CASH_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int iD = rs.getInt("ID");
	                int shipID = rs.getInt("ShipmentID");
	                int vouID = rs.getInt("VoucherID");
	                Shipment shipment = getShipmentByID(shipID);
	                Voucher voucher = getVoucherByID(vouID);
	                int amount = rs.getInt("amount");
	                int iD2 = rs.getInt("ID2");
	                float cashTendered = rs.getFloat("cashTendered");
	                cash = new Cash(iD, amount, shipment, voucher, iD2, cashTendered);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return cash;
	}
	
	public Check findCheckByID(int ID){
		Check checks = null;
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CHECKS_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int iD = rs.getInt("ID");
	                int shipID = rs.getInt("ShipmentID");
	                int vouID = rs.getInt("VoucherID");
	                Shipment shipment = getShipmentByID(shipID);
	                Voucher voucher = getVoucherByID(vouID);
	                int amount = rs.getInt("amount");
	                int iD2 = rs.getInt("ID3");
	                String name = rs.getString("name");
	                String bankID = rs.getString("bankID");
	                checks = new Check(iD, amount, shipment, voucher, iD2, name, bankID);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return checks;
	}
	
	public Credit findCreditByID(int ID){
		Credit credit1 = null;
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CREDIT_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int iD = rs.getInt("ID");
	                int shipID = rs.getInt("ShipmentID");
	                int vouID = rs.getInt("VoucherID");
	                Shipment shipment = getShipmentByID(shipID);
	                Voucher voucher = getVoucherByID(vouID);
	                int amount = rs.getInt("amount");
	                int iD2 = rs.getInt("ID4");
	                String number = rs.getString("number");
	                String type = rs.getString("type");
	                String expString = rs.getString("expString");
	                credit1 = new Credit(iD, amount, shipment, voucher, iD2, number, type, expString);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return credit1;
	}
	
}