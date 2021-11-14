package controller.shoesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.shoes.ManufacturerShoes;
import model.shoes.Shoes;
import model.shoes.ShoesItem;

public class ShoesItemDAOImp implements ShoesItemDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String SELECT_ALL_SKITEM_ID = "SELECT * FROM shoesitem WHERE ShoesID IN (SELECT ID FROM Shoes WHERE ID2 is NOT NULL); ";
    private static final String SELECT_ALL_BOITEM_ID = "SELECT * FROM shoesitem WHERE ShoesID IN (SELECT ID FROM Shoes WHERE ID3 is NOT NULL); ";
    private static final String SELECT_ALL_SDITEM_ID = "SELECT * FROM shoesitem WHERE ShoesID IN (SELECT ID FROM Shoes WHERE ID4 is NOT NULL); ";
    private static final String UPDATE_SITEM_ID = "UPDATE shoesitem SET quantity= ? WHERE ID = ?;";
    private static final String SELECT_SITEM_ID = "select * from shoesitem where id =?;";
    private static final String SELECT_SHOES_ID = "select * from Shoes where id =?;";
    private static final String SELECT_NUM_BY_ID = "select quantity from shoesitem where ID = ?";
    private static final String SELECT_MAN_BY_ID = "select * from ManufacturerShoes where id =?";
    
	public ShoesItemDAOImp() {}
	
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
	
	public void addShoesItem() {
		// TODO - implement ShoesItemDAOImp.addShoesItem
		throw new UnsupportedOperationException();
	}

	public void deleteShoesItem() {
		// TODO - implement ShoesItemDAOImp.deleteShoesItem
		throw new UnsupportedOperationException();
	}

	public void updateShoesItem(int ID, int numbers) {
		// TODO - implement ShoesItemDAOImp.updateShoesItem
		// TODO - implement ClothesItemDAOImp.updateClothesItem
			int prevNum = getNum(ID);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SITEM_ID)) {
	            preparedStatement.setInt(1, prevNum-numbers);
	            preparedStatement.setInt(2, ID);
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	public void getAll() {
		// TODO - implement ShoesItemDAOImp.getAll
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
	
	public Shoes getShoesByID(int ID) {
		Shoes shoes = null;
        // Step 1: Establishing a Connection
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHOES_ID);) {
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
	                shoes = new Shoes(iD, man, gender, weight, launched, material);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return shoes;
	}
	
	public List <ShoesItem> findAllSneakerItem() {
		List < ShoesItem > shoesitem = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SKITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int shoesID = rs.getInt("shoesID");
                Shoes shoes = getShoesByID(shoesID);
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                shoesitem.add(new ShoesItem(ID, shoes, quantity, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoesitem;
	}
	
	public List <ShoesItem> findAllBootItem() {
		List < ShoesItem > shoesitem = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int shoesID = rs.getInt("shoesID");
                Shoes shoes = getShoesByID(shoesID);
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                shoesitem.add(new ShoesItem(ID, shoes, quantity, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoesitem;
	}
	
	public List <ShoesItem> findAllSandalItem() {
		List < ShoesItem > shoesitem = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SDITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int shoesID = rs.getInt("shoesID");
                Shoes shoes = getShoesByID(shoesID);
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                shoesitem.add(new ShoesItem(ID, shoes, quantity, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoesitem;
	}
	
	public ShoesItem getShoesItemByID(int ID) {
		ShoesItem shoesitem = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SITEM_ID);) {
        	preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int iD = rs.getInt("ID");
                int shoesID = rs.getInt("shoesID");
                Shoes shoes = getShoesByID(shoesID);
                int quantity = rs.getInt("Quantity");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                shoesitem = new ShoesItem(iD, shoes, quantity, price, discount, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoesitem;
	}
}