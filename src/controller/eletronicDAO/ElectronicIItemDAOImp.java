package controller.eletronicDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.electronic.Electronic;
import model.electronic.ElectronicItem;
import model.electronic.ManufacturerElectronics;

public class ElectronicIItemDAOImp implements ElectronicItemDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String SELECT_ALL_LTITEM_ID = "SELECT * FROM electronicitem WHERE ElectronicID IN (SELECT ID FROM Electronic WHERE ID3 is NOT NULL); ";
    private static final String SELECT_ALL_COITEM_ID = "SELECT * FROM electronicitem WHERE ElectronicID IN (SELECT ID FROM Electronic WHERE ID4 is NOT NULL); ";
    private static final String SELECT_ALL_MBITEM_ID = "SELECT * FROM electronicitem WHERE ElectronicID IN (SELECT ID FROM Electronic WHERE ID2 is NOT NULL); ";
    private static final String UPDATE_EITEM_ID = "UPDATE electronicitem SET quantity= ? WHERE ID = ?;";
    private static final String SELECT_EITEM_ID = "select * from electronicitem where id =?;";
    private static final String SELECT_ELEC_ID = "select * from Electronic where id =?;";
    private static final String SELECT_NUM_BY_ID = "select quantity from electronicitem where ID = ?";
    private static final String SELECT_MAN_BY_ID = "select * from ManufacturerElectronics where id =?";
    
	public ElectronicIItemDAOImp() {}

	public void addElectronicItem() {
		// TODO - implement ElectronicIItemDAOImp.addElectronicItem
		throw new UnsupportedOperationException();
	}

	public void deleteElectronicItem() {
		// TODO - implement ElectronicIItemDAOImp.deleteElectronicItem
		throw new UnsupportedOperationException();
	}

	public void updateElectronicItem(int ID, int numbers) {
		// TODO - implement ElectronicIItemDAOImp.updateElectronicItem
		int prevNum = getNum(ID);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EITEM_ID)) {
            preparedStatement.setInt(1, prevNum-numbers);
            preparedStatement.setInt(2, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void getAll() {
		// TODO - implement ElectronicIItemDAOImp.getAll
		throw new UnsupportedOperationException();
	}
	
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
	
	public int getNum(int ID){
		int quantity = 0;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NUM_BY_ID)) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
            	quantity = rs.getInt("quantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return quantity;
	}  
	
	public ManufacturerElectronics getManufacturerElectronics(int ID) {
		ManufacturerElectronics man = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MAN_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int iD = rs.getInt("ID");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String description = rs.getString("description");
                man = new ManufacturerElectronics(iD, name, country, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return man;
	}
	
	public Electronic getElectronicByID(int ID) {
		Electronic elec = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ELEC_ID);) {
        	preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int iD = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerElectronicsID");
                ManufacturerElectronics man = getManufacturerElectronics(manID);
                String name = rs.getString("name");
                int year = rs.getInt("year");
                String certificates = rs.getString("certificates");
                String safetyClaims = rs.getString("safetyClaims");
                elec = new Electronic(iD, man, name, year, certificates, safetyClaims);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return elec;
	}
	
	public List <ElectronicItem> findAllMobileItem() {
		List < ElectronicItem > electronicitem = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MBITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int ElectronicID = rs.getInt("ElectronicID");
                Electronic electronic = getElectronicByID(ElectronicID);
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                electronicitem.add(new ElectronicItem(ID, electronic, quantity, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return electronicitem;
	}
	
	public List <ElectronicItem> findAllLaptopItem() {
		List < ElectronicItem > electronicitem = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LTITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int ElectronicID = rs.getInt("ElectronicID");
                Electronic electronic = getElectronicByID(ElectronicID);
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                electronicitem.add(new ElectronicItem(ID, electronic, quantity, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return electronicitem;
	}
	
	public List <ElectronicItem> findAllComputerItem() {
		List < ElectronicItem > electronicitem = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int ElectronicID = rs.getInt("ElectronicID");
                Electronic electronic = getElectronicByID(ElectronicID);
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                electronicitem.add(new ElectronicItem(ID, electronic, quantity, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return electronicitem;
	}
	
	public List <ElectronicItem> getElectronicItemByID(int ID) {
		List < ElectronicItem > electronicitem = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EITEM_ID);) {
        	preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int iD = rs.getInt("ID");
                int ElectronicID = rs.getInt("ElectronicID");
                Electronic electronic = getElectronicByID(ElectronicID);
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                electronicitem.add(new ElectronicItem(iD, electronic, quantity, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return electronicitem;
	}
}