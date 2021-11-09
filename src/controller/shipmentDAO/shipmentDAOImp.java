package controller.shipmentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mode.shipment.Shipment;
import model.payment.Payment;

public class shipmentDAOImp implements shipmentDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookstoremanagement?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
	private static final String SELECT_SM_BY_ID = "select id,company,shipmentprice from shipment where ID =?";
    private static final String SELECT_ALL_SM = "select * from shipment";
    
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
    
	public void insertShipmentMethod() {
		// TODO - implement shipmentDAOImp.insertShipmentMethod
		throw new UnsupportedOperationException();
	}

	public void deleteShipmentMethod() {
		// TODO - implement shipmentDAOImp.deleteShipmentMethod
		throw new UnsupportedOperationException();
	}

	public void updateShipmentMethod() {
		// TODO - implement shipmentDAOImp.updateShipmentMethod
		throw new UnsupportedOperationException();
	}

	public List<Shipment> findAllShipment() {
		List < Shipment > shipments = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SM);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                String company = rs.getString("company");
                float shipmentPrice = rs.getFloat("shipmentPrice");
                Shipment shipment = new Shipment(ID, company, shipmentPrice);
                shipments.add(shipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shipments;
	}

	public Shipment selectShipment(int ID) {
		Shipment shipment = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SM_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String company = rs.getString("company");
                float shipmentPrice = rs.getFloat("shipmentPrice");
                shipment = new Shipment(ID, company, shipmentPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shipment;
	}

}