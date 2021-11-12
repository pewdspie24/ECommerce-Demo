package controller.clothesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.clothes.Clothes;
import model.clothes.ClothesItem;
import model.clothes.ManufacturerClothes;

public class ClothesItemDAOImp implements ClothesItemDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String SELECT_ALL_JEITEM_ID = "SELECT * FROM clothesitem WHERE ClothesID IN (SELECT ID FROM Clothes WHERE ID3 is NOT NULL); ";
    private static final String SELECT_ALL_SOITEM_ID = "SELECT * FROM clothesitem WHERE ClothesID IN (SELECT ID FROM Clothes WHERE ID4 is NOT NULL); ";
    private static final String SELECT_ALL_SIITEM_ID = "SELECT * FROM clothesitem WHERE ClothesID IN (SELECT ID FROM Clothes WHERE ID2 is NOT NULL); ";
    private static final String UPDATE_CITEM_ID = "UPDATE clothesitem SET quantity= ? WHERE ID = ?;";
    private static final String SELECT_CITEM_ID = "select * from clothesitem where id =?;";
    private static final String SELECT_BOOK_ID = "select * from Clothes where id =?;";
    private static final String SELECT_NUM_BY_ID = "select quantity from clothesitem where ID = ?";
    private static final String SELECT_MAN_BY_ID = "select * from ManufacturerClothes where id =?";
    
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
		int instock = 0;
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NUM_BY_ID)) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
            	instock = rs.getInt("instock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return instock;
	}    
    
	public void addClothesItem() {
		// TODO - implement ClothesItemDAOImp.addClothesItem
		throw new UnsupportedOperationException();
	}

	public void deleteClothesItem() {
		// TODO - implement ClothesItemDAOImp.deleteClothesItem
		throw new UnsupportedOperationException();
	}

	public void updateClothesItem(int ID, int numbers) {
		// TODO - implement ClothesItemDAOImp.updateClothesItem
		int prevNum = getNum(ID);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CITEM_ID)) {
            preparedStatement.setInt(1, prevNum-numbers);
            preparedStatement.setInt(2, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
	
	public Clothes getClothesByID(int ID) {
		Clothes clothes = null;
        // Step 1: Establishing a Connection
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_ID);) {
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
	                clothes = new Clothes(iD, man, gender, type, material);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return clothes;
	}
	
	public List <ClothesItem> findAllJeansItem() {
		List < ClothesItem > clothesitem = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_JEITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int clothesID = rs.getInt("clothesID");
                Clothes clothes = getClothesByID(clothesID);
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                clothesitem.add(new ClothesItem(ID, clothes, quantity, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clothesitem;
	}
	
	public List <ClothesItem> findAllShortItem() {
		List < ClothesItem > clothesitem = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SOITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int clothesID = rs.getInt("clothesID");
                Clothes clothes = getClothesByID(clothesID);
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                clothesitem.add(new ClothesItem(ID, clothes, quantity, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clothesitem;
	}
	
	public List <ClothesItem> findAllShirtItem() {
		List < ClothesItem > clothesitem = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SIITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int clothesID = rs.getInt("clothesID");
                Clothes clothes = getClothesByID(clothesID);
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                clothesitem.add(new ClothesItem(ID, clothes, quantity, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clothesitem;
	}
	
	public ClothesItem getClothesItemByID(int ID) {
		ClothesItem clothesItem = null;
        // Step 1: Establishing a Connection
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CITEM_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int iD = rs.getInt("ID");
	                int ClothesID = rs.getInt("ClothesID");
	                Clothes clothes = getClothesByID(ClothesID);
	                int quantity = rs.getInt("quantity");
	                float price = rs.getFloat("price");
	                float discount = rs.getFloat("discount");
	                String date = rs.getString("date");
	                clothesItem = new ClothesItem(iD, clothes, quantity, price, discount, date);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return clothesItem;
	}
}