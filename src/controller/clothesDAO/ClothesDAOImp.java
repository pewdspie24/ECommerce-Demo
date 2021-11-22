package controller.clothesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.clothes.Jeans;
import model.clothes.ManufacturerClothes;
import model.clothes.Shirt;
import model.clothes.Short;

public class ClothesDAOImp implements ClothesDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String SELECT_SHIRT_BY_ID = "select * from clothes where id =?;";
    private static final String SELECT_JEANS_BY_ID = "select * from clothes where id =?;";
    private static final String SELECT_SHORT_BY_ID = "select * from clothes where id =?;";
    private static final String CHECK_TYPES_SHIRTS = "select * from clothes where id =? and id2 is not null;";
    private static final String CHECK_TYPES_JEANS = "select * from clothes where id =? and id3 is not null;";
    private static final String CHECK_TYPES_SHORTS = "select * from clothes where id =? and id4 is not null;";
    private static final String SELECT_ALL_SHIRTS = "select * from clothes where id2 is not null;";
    private static final String SELECT_ALL_JEANS = "select * from clothes where id3 is not null;";
    private static final String SELECT_ALL_SHORTS = "select * from clothes where id4 is not null;";
    private static final String SELECT_MAN_BY_ID = "select * from ManufacturerClothes where id =?";
    
    public ClothesDAOImp() {}
    
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
	public void insertClothes() {
		// TODO - implement ClothesDAOImp.addClothes
		throw new UnsupportedOperationException();
	}

	public void deleteClothes() {
		// TODO - implement ClothesDAOImp.deleteClothes
		throw new UnsupportedOperationException();
	}

	public void updateClothes() {
		// TODO - implement ClothesDAOImp.updateClothes
		throw new UnsupportedOperationException();
	}
	
	public ManufacturerClothes getManufacturerClothes(int ID) {
		ManufacturerClothes man = null;
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
                man = new ManufacturerClothes(iD, name, country, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return man;
	}
	
	public List <Jeans> findAllJeans() {
		List < Jeans > jeans = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_JEANS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerClothesID");
                ManufacturerClothes man = getManufacturerClothes(manID);
                String gender = rs.getString("gender");
                String type = rs.getString("type");
                String material = rs.getString("material");
                int iD2 = rs.getInt("ID3");
                String type2 = rs.getString("type3");
                String length = rs.getString("length");
                String pocketAvailable = rs.getString("pocketAvailable");
                jeans.add(new Jeans(ID, man, gender, type, material, iD2, type2, length, pocketAvailable));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jeans;
	}
	
	public List <Shirt> findAllShirt() {
		List < Shirt > shirts = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SHIRTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerClothesID");
                ManufacturerClothes man = getManufacturerClothes(manID);
                String gender = rs.getString("gender");
                String type = rs.getString("type");
                String material = rs.getString("material");
                int iD2 = rs.getInt("ID2");
                String type2 = rs.getString("type2");
                String fashionList = rs.getString("fashionList");
                String sleeveType = rs.getString("sleeveType");
                shirts.add(new Shirt(ID, man, gender, type, material, iD2, type2, fashionList, sleeveType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shirts;
	}
	
	public List <Short> findAllShort() {
		List < Short > shorts = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SHORTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerClothesID");
                ManufacturerClothes man = getManufacturerClothes(manID);
                String gender = rs.getString("gender");
                String type = rs.getString("type");
                String material = rs.getString("material");
                int ID2 = rs.getInt("ID4");
                String type2 = rs.getString("type4");
                String length = rs.getString("length2");
                String age = rs.getString("age");
                String fashionList = rs.getString("fashionList");
                shorts.add(new Short(ID, man, gender, type, material, ID2, type2, length, age, fashionList));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shorts;
	}
	
	public int checkType(int ID){
		int flag = 0;
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_SHIRTS);) {
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
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_JEANS);) {
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
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_SHORTS);) {
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
	
	public Shirt findShirtByID(int ID) {
		Shirt shirt = null;
        // Step 1: Establishing a Connection
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHIRT_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int iD = rs.getInt("ID");
	                int manID = rs.getInt("ManufacturerClothesID");
	                ManufacturerClothes man = getManufacturerClothes(manID);
	                String gender = rs.getString("gender");
	                String type = rs.getString("type");
	                String material = rs.getString("material");
	                int iD2 = rs.getInt("ID2");
	                String type2 = rs.getString("type2");
	                String fashionList = rs.getString("fashionList");
	                String sleeveType = rs.getString("sleeveType");
	                shirt = new Shirt(iD, man, gender, type, material, iD2, type2, fashionList, sleeveType);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return shirt;
	}
	
	public Jeans findJeansByID(int ID){
		Jeans jeans = null;
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_JEANS_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int iD = rs.getInt("ID");
	                int manID = rs.getInt("ManufacturerClothesID");
	                ManufacturerClothes man = getManufacturerClothes(manID);
	                String gender = rs.getString("gender");
	                String type = rs.getString("type");
	                String material = rs.getString("material");
	                int iD2 = rs.getInt("ID3");
	                String type2 = rs.getString("type3");
	                String length = rs.getString("length");
	                String pocketAvailable = rs.getString("pocketAvailable");
	                jeans = new Jeans(iD, man, gender, type, material, iD2, type2, length, pocketAvailable);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return jeans;
	}
	
	public Short findShortByID(int ID){
		Short short1 = null;
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHORT_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int iD = rs.getInt("ID");
	                int manID = rs.getInt("ManufacturerClothesID");
	                ManufacturerClothes man = getManufacturerClothes(manID);
	                String gender = rs.getString("gender");
	                String type = rs.getString("type");
	                String material = rs.getString("material");
	                int ID2 = rs.getInt("ID4");
	                String type2 = rs.getString("type4");
	                String length = rs.getString("length2");
	                String age = rs.getString("age");
	                String fashionList = rs.getString("fashionList");
	                short1 = new Short(iD, man, gender, type, material, ID2, type2, length, age, fashionList);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return short1;
	}
	
}