package controller.shoesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.shoes.Boot;
import model.shoes.ManufacturerShoes;
import model.shoes.Sandal;
import model.shoes.Sneaker;

public class ShoesDAOImp implements ShoesDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String SELECT_SNEAKER_BY_ID = "select * from shoes where id =?;";
    private static final String SELECT_BOOT_BY_ID = "select * from shoes where id =?;";
    private static final String SELECT_SANDAL_BY_ID = "select * from shoes where id =?;";
    private static final String CHECK_TYPES_SNEAKER = "select * from shoes where id =? and id2 is not null;";
    private static final String CHECK_TYPES_BOOT = "select * from shoes where id =? and id3 is not null;";
    private static final String CHECK_TYPES_SANDAL = "select * from shoes where id =? and id4 is not null;";
    private static final String SELECT_ALL_SNEAKERS = "select * from shoes where id2 is not null;";
    private static final String SELECT_ALL_BOOTS = "select * from shoes where id3 is not null;";
    private static final String SELECT_ALL_SANDALS = "select * from shoes where id4 is not null;";
    private static final String SELECT_MAN_BY_ID = "select * from ManufacturerShoes where id =?";
    
    public ShoesDAOImp() {}
    
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
    
	public void addShoes() {
		// TODO - implement ShoesDAOImp.addShoes
		throw new UnsupportedOperationException();
	}

	public void deleteShoes() {
		// TODO - implement ShoesDAOImp.deleteShoes
		throw new UnsupportedOperationException();
	}

	public void updateShoes() {
		// TODO - implement ShoesDAOImp.updateShoes
		throw new UnsupportedOperationException();
	}
	
	public ManufacturerShoes getManufacturerShoes(int ID) {
		ManufacturerShoes man = null;
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
                man = new ManufacturerShoes(iD, name, country, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return man;
	}
	
	public List <Sneaker> findAllSneaker() {
		List < Sneaker > sneaker = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SNEAKERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerShoesID");
                ManufacturerShoes man = getManufacturerShoes(manID);
                String gender = rs.getString("gender");
                String weight = rs.getString("weight");
                String launched = rs.getString("launched");
                String material = rs.getString("material");
                int iD2 = rs.getInt("ID2");
                String style = rs.getString("style");
                String type = rs.getString("type");
                String brandName = rs.getString("brandName");
                sneaker.add(new Sneaker(ID, man, gender, weight, launched, material, iD2, style, type, brandName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sneaker;
	}
	
	public List <Boot> findAllBoot() {
		List < Boot > boot = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerShoesID");
                ManufacturerShoes man = getManufacturerShoes(manID);
                String gender = rs.getString("gender");
                String weight = rs.getString("weight");
                String launched = rs.getString("launched");
                String material = rs.getString("material");
                int iD2 = rs.getInt("ID3");
                String height = rs.getString("height");
                String style = rs.getString("style2");
                String type = rs.getString("type2");
                String brandName = rs.getString("brandName2");
                String fashionList = rs.getString("fashionList");
                boot.add(new Boot(ID, man, gender, weight, launched, material, iD2, height, type, brandName, style, fashionList));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boot;
	}
	
	public List <Sandal> findAllSandal() {
		List < Sandal > sandal = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SANDALS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerShoesID");
                ManufacturerShoes man = getManufacturerShoes(manID);
                String gender = rs.getString("gender");
                String weight = rs.getString("weight");
                String launched = rs.getString("launched");
                String material = rs.getString("material");
                int iD2 = rs.getInt("ID4");
                String style = rs.getString("style3");
                String type = rs.getString("type3");
                String brandName = rs.getString("brandName3");
                sandal.add(new Sandal(ID, man, gender, weight, launched, material, iD2, style, type, brandName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sandal;
	}
	
	public int checkType(int ID){
		int flag = 0;
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_SNEAKER);) {
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
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_BOOT);) {
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
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_SANDAL);) {
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
	
	public Sneaker findSneakerByID(int ID) {
		Sneaker sneaker = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SNEAKER_BY_ID);) {
        	preparedStatement.setInt(1, ID);
        	System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int iD = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerShoesID");
                ManufacturerShoes man = getManufacturerShoes(manID);
                String gender = rs.getString("gender");
                String weight = rs.getString("weight");
                String launched = rs.getString("launched");
                String material = rs.getString("material");
                int iD2 = rs.getInt("ID2");
                String style = rs.getString("style");
                String type = rs.getString("type");
                String brandName = rs.getString("brandName");
                sneaker = new Sneaker(iD, man, gender, weight, launched, material, iD2, style, type, brandName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sneaker;
	}
	
	public Boot findBootByID(int ID) {
		Boot boot = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOT_BY_ID);) {
        	preparedStatement.setInt(1, ID);
        	System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int iD = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerShoesID");
                ManufacturerShoes man = getManufacturerShoes(manID);
                String gender = rs.getString("gender");
                String weight = rs.getString("weight");
                String launched = rs.getString("launched");
                String material = rs.getString("material");
                int iD2 = rs.getInt("ID3");
                String height = rs.getString("height");
                String style = rs.getString("style2");
                String type = rs.getString("type2");
                String brandName = rs.getString("brandName2");
                String fashionList = rs.getString("fashionList");
                boot = new Boot(iD, man, gender, weight, launched, material, iD2, height, type, brandName, style, fashionList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boot;
	}
	
	public Sandal findSandalByID(int ID) {
		Sandal sandal = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SANDAL_BY_ID);) {
        	preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int iD = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerShoesID");
                ManufacturerShoes man = getManufacturerShoes(manID);
                String gender = rs.getString("gender");
                String weight = rs.getString("weight");
                String launched = rs.getString("launched");
                String material = rs.getString("material");
                int iD2 = rs.getInt("ID4");
                String style = rs.getString("style3");
                String type = rs.getString("type3");
                String brandName = rs.getString("brandName3");
                sandal = new Sandal(iD, man, gender, weight, launched, material, iD2, style, type, brandName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sandal;
	}
	
}