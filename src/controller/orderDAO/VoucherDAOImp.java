package controller.orderDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.order.VoucherConstant;
import model.order.VoucherPercentage;


public class VoucherDAOImp implements VoucherDAO{
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String SELECT_VC_BY_ID = "select * from voucher where id =?;";
    private static final String SELECT_VP_BY_ID = "select * from voucher where id =?;";
    private static final String CHECK_TYPES_VC = "select * from voucher where id =? and id2 is not null;";
    private static final String CHECK_TYPES_VP = "select * from voucher where id =? and id3 is not null;";
    private static final String SELECT_ALL_VC = "select * from voucher where id2 is not null;";
    private static final String SELECT_ALL_VP = "select * from voucher where id3 is not null;";
    
    public VoucherDAOImp() {}
    
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
	public void insertVoucher() {
		// TODO - implement VoucherDAOImp.addVoucher
		throw new UnsupportedOperationException();
	}

	public void deleteVoucher() {
		// TODO - implement VoucherDAOImp.deleteVoucher
		throw new UnsupportedOperationException();
	}

	public void updateVoucher() {
		// TODO - implement VoucherDAOImp.updateVoucher
		throw new UnsupportedOperationException();
	}

	
	public List <VoucherConstant> findAllVoucherConstant() {
		List < VoucherConstant > voucherconstants = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VC);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("name");
                String expiresDate = rs.getString("expiresDate");
                int iD2 = rs.getInt("ID2");
                float quantity = rs.getFloat("quantity");
                voucherconstants.add(new VoucherConstant(ID, name, expiresDate, iD2, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voucherconstants;
	}
	
	public List <VoucherPercentage> findAllVoucherPercentage() {
		List < VoucherPercentage > voucherpercentagess = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VP);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                String name = rs.getString("name");
                String expiresDate = rs.getString("expiresDate");
                int iD2 = rs.getInt("ID3");
                int percentage = rs.getInt("percentage");
                voucherpercentagess.add(new VoucherPercentage(ID, name, expiresDate, iD2, percentage));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voucherpercentagess;
	}
	
	public int checkType(int ID){
		int flag = 0;
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_VC);) {
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
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_VP);) {
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
		return flag;
	}
	
	public VoucherPercentage findVoucherPercentageByID(int ID) {
		VoucherPercentage voucherpercentages = null;
        // Step 1: Establishing a Connection
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VP_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int iD = rs.getInt("ID");
	            	String name = rs.getString("name");
	                String expiresDate = rs.getString("expiresDate");
	                int iD2 = rs.getInt("ID3");
	                int percentage = rs.getInt("percentage");
	                voucherpercentages = new VoucherPercentage(iD, name, expiresDate, iD2, percentage);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return voucherpercentages;
	}
	
	public VoucherConstant findVoucherConstantByID(int ID){
		VoucherConstant voucherconstants = null;
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VC_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int iD = rs.getInt("ID");
	                String name = rs.getString("name");
	                String expiresDate = rs.getString("expiresDate");
	                int iD2 = rs.getInt("ID2");
	                float quantity = rs.getFloat("quantity");
	                voucherconstants = new VoucherConstant(iD, name, expiresDate, iD2, quantity);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return voucherconstants;
	}

	
}
