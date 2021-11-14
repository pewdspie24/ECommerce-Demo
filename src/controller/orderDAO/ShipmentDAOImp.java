package controller.orderDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.order.AbroadShipment;
import model.order.EconomicalShipment;
import model.order.FastShipment;

public class ShipmentDAOImp implements ShipmentDAO{
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String SELECT_FAST_BY_ID = "select * from shipment where id =?;";
    private static final String SELECT_ECOS_BY_ID = "select * from shipment where id =?;";
    private static final String SELECT_ABROAD_BY_ID = "select * from shipment where id =?;";
    private static final String CHECK_TYPES_FASTS = "select * from shipment where id =? and id2 is not null;";
    private static final String CHECK_TYPES_ECOS = "select * from shipment where id =? and id3 is not null;";
    private static final String CHECK_TYPES_ABROADS = "select * from shipment where id =? and id4 is not null;";
    private static final String SELECT_ALL_FASTS = "select * from shipment where id2 is not null;";
    private static final String SELECT_ALL_ECOS = "select * from shipment where id3 is not null;";
    private static final String SELECT_ALL_ABROADS = "select * from shipment where id4 is not null;";
    
    public ShipmentDAOImp() {}
    
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
	public void insertShipment() {
		// TODO - implement ShipmentDAOImp.addShipment
		throw new UnsupportedOperationException();
	}

	public void deleteShipment() {
		// TODO - implement ShipmentDAOImp.deleteShipment
		throw new UnsupportedOperationException();
	}

	public void updateShipment() {
		// TODO - implement ShipmentDAOImp.updateShipment
		throw new UnsupportedOperationException();
	}
	
	public List <EconomicalShipment> findAllEconomicalShipment() {
		List < EconomicalShipment > ecos = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ECOS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                float price = rs.getInt("price");
                String description = rs.getString("description");
                int iD2 = rs.getInt("ID3");
                String company = rs.getString("company");
                ecos.add(new EconomicalShipment(ID, price, description, iD2, company));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ecos;
	}
	
	public List <FastShipment> findAllFastShipment() {
		List < FastShipment > fasts = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FASTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                float price = rs.getInt("price");
                String description = rs.getString("description");
                int iD2 = rs.getInt("ID2");
                String city = rs.getString("city");
                String timeDesired = rs.getString("timeDesired");
                fasts.add(new FastShipment(ID, price, description, iD2, city, timeDesired));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fasts;
	}
	
	public List <AbroadShipment> findAllAbroadShipment() {
		List < AbroadShipment > abroadss = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ABROADS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                float price = rs.getInt("price");
                String description = rs.getString("description");
                int iD2 = rs.getInt("ID4");
                String country = rs.getString("country");
                float tax = rs.getFloat("tax");
                abroadss.add(new AbroadShipment(ID, price, description, iD2, country, tax));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abroadss;
	}
	
	public int checkType(int ID){
		int flag = 0;
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_FASTS);) {
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
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_ECOS);) {
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
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_ABROADS);) {
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
	
	public FastShipment findFastShipmentByID(int ID) {
		FastShipment fasts = null;
        // Step 1: Establishing a Connection
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FAST_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int id = rs.getInt("ID");
	                float price = rs.getInt("price");
	                String description = rs.getString("description");
	                int iD2 = rs.getInt("ID2");
	                String city = rs.getString("city");
	                String timeDesired = rs.getString("timeDesired");
	                fasts = new FastShipment(id, price, description, iD2, city, timeDesired);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return fasts;
	}
	
	public EconomicalShipment findEconomicalShipmentByID(int ID){
		EconomicalShipment ecos = null;
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ECOS_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int iD = rs.getInt("ID");
	                float price = rs.getInt("price");
	                String description = rs.getString("description");
	                int iD2 = rs.getInt("ID3");
	                String company = rs.getString("company");
	                ecos = new EconomicalShipment(iD, price, description, iD2, company);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ecos;
	}
	
	public AbroadShipment findAbroadShipmentByID(int ID){
		AbroadShipment abroads1 = null;
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ABROAD_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int iD = rs.getInt("ID");
	                float price = rs.getInt("price");
	                String description = rs.getString("description");
	                int iD2 = rs.getInt("ID4");
	                String country = rs.getString("country");
	                float tax = rs.getFloat("tax");
	                abroads1 = new AbroadShipment(iD, price, description, iD2, country, tax);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return abroads1;
	}
}
