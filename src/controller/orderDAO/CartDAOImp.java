package controller.orderDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.customerDAO.CustomerDAOImp;
import java.util.HashMap;
import model.book.*;
import model.clothes.*;
import model.customer.Customer;
import model.electronic.ElectronicItem;
import model.order.Cart;
import model.shoes.*;

public class CartDAOImp implements CartDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String INSERT_CART_SQL = "INSERT INTO cart"
            + "  (customerID, createdAt, updatedAt, totalQuantity, totalPrice) VALUES " + " (?, ?, ?, ?, ?);";
    private static final String UPDATE_CART_BY_ID = "UPDATE cart SET totalPrice= ? AND totalQuantity = ? WHERE ID = ?;";
    private static final String SELECT_CART_BY_ID = "select id, customerID from cart where customerID =?";
    private static final String INSERT_BITEM_CART = "INSERT INTO bookitem_cart"
            + "  (BookitemID, cartID, quantity) VALUES " + " (?, ?, ?);";
    private static final String INSERT_CITEM_CART = "INSERT INTO clothesitem_cart"
            + "  (ClothesitemID, cartID, quantity) VALUES " + " (?, ?, ?);";
    private static final String INSERT_EITEM_CART = "INSERT INTO electronicitem_cart"
            + "  (ElectronicitemID, cartID, quantity) VALUES " + " (?, ?, ?);";
    private static final String INSERT_SITEM_CART = "INSERT INTO shoesitem_cart"
            + "  (ShoesitemID, cartID, quantity) VALUES " + " (?, ?, ?);";
    private static final String SELECT_BITEM_CART = "SELECT * FROM bookitem_cart where cartID =?;";
    private static final String SELECT_CITEM_CART = "SELECT * FROM clothesitem_cart where cartID =?;";
    private static final String SELECT_EITEM_CART = "SELECT * FROM electronicitem_cart where cartID =?;";
    private static final String SELECT_SITEM_CART = "SELECT * FROM shoesitem_cart where cartID =?;";
    
    private static final String UPDATE_BITEM_CART = "UPDATE bookitem_cart SET quantity = quantity+1 WHERE cartID = ? AND bookitemID = ?;";
    private static final String UPDATE_CITEM_CART = "UPDATE clothesitem_cart SET quantity = quantity+1 WHERE cartID = ? AND ClothesitemID = ?;";
    private static final String UPDATE_EITEM_CART = "UPDATE electronicitem_cart SET quantity = quantity+1 WHERE cartID = ? AND ElectronicitemID = ?;";
    private static final String UPDATE_SITEM_CART = "UPDATE shoesitem_cart SET quantity = quantity+1 WHERE cartID = ? AND ShoesitemID = ?;";
    
    private static final String CHECK_SITEM_CART = "SELECT quantity FROM shoesitem_cart where cartID = ? AND ShoesitemID = ?;";
    private static final String CHECK_BITEM_CART = "SELECT quantity FROM bookitem_cart where cartID = ? AND bookitemID = ?;";
    private static final String CHECK_CITEM_CART = "SELECT quantity FROM clothesitem_cart where cartID = ? AND ClothesitemID = ?;";
    private static final String CHECK_EITEM_CART = "SELECT quantity FROM electronicitem_cart where cartID = ? AND ElectronicitemID = ?;";

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

    /**
     * 
     * @param book
     */
    public void addBookitem(Cart cart, BookItem book, int quantity) {
        // TODO - implement CartDAOImp.addBookitem
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BITEM_CART)) {
            preparedStatement.setInt(1, book.getID());
            preparedStatement.setInt(2, cart.getID());
            preparedStatement.setInt(3, quantity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param electronics
     */
    public void addElectronicItem(Cart cart, ElectronicItem electronic, int quantity) {
        // TODO - implement CartDAOImp.addElectronicItem
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EITEM_CART)) {
            preparedStatement.setInt(1, electronic.getID());
            preparedStatement.setInt(2, cart.getID());
            preparedStatement.setInt(3, quantity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param clothes
     */
    public void addClothesItem(Cart cart, ClothesItem clothes, int quantity) {
        // TODO - implement CartDAOImp.addClothesItem
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CITEM_CART)) {
            preparedStatement.setInt(1, clothes.getID());
            preparedStatement.setInt(2, cart.getID());
            preparedStatement.setInt(3, quantity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param shoes
     */
    public void addShoesItem(Cart cart, ShoesItem shoes, int quantity) {
        // TODO - implement CartDAOImp.addShoesItem
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SITEM_CART)) {
            preparedStatement.setInt(1, shoes.getID());
            preparedStatement.setInt(2, cart.getID());
            preparedStatement.setInt(3, quantity);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateBookitem(Cart cart, BookItem book) {
        // TODO - implement CartDAOImp.addBookitem
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BITEM_CART)) {
            preparedStatement.setInt(2, book.getID());
            preparedStatement.setInt(1, cart.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateClothesitem(Cart cart, ClothesItem book) {
        // TODO - implement CartDAOImp.addBookitem
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CITEM_CART)) {
            preparedStatement.setInt(2, book.getID());
            preparedStatement.setInt(1, cart.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateElectronicitem(Cart cart, ElectronicItem book) {
        // TODO - implement CartDAOImp.addBookitem
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EITEM_CART)) {
            preparedStatement.setInt(2, book.getID());
            preparedStatement.setInt(1, cart.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void updateShoesitem(Cart cart, ShoesItem book) {
        // TODO - implement CartDAOImp.addBookitem
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SITEM_CART)) {
            preparedStatement.setInt(2, book.getID());
            preparedStatement.setInt(1, cart.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int checkBookitem(Cart cart, BookItem book) {
        // Step 1: Establishing a Connection
    	int quantity = 0;
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BITEM_CART);) {
            preparedStatement.setInt(1, cart.getID());
            preparedStatement.setInt(2, book.getID());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                quantity = rs.getInt("quantity");
                // String createdAt = rs.getString("createdAt");
                // String updatedAt= rs.getString("updatedAt");
                // Float totalPrice = rs.getFloat("totalPrice");
                // int totalQuantity = rs.getInt("totalQuantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantity;
    }
    
    public int checkElectronicitem(Cart cart, ElectronicItem elec) {
        // Step 1: Establishing a Connection
    	int quantity = 0;
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_EITEM_CART);) {
            preparedStatement.setInt(1, cart.getID());
            preparedStatement.setInt(2, elec.getID());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                quantity = rs.getInt("quantity");
                // String createdAt = rs.getString("createdAt");
                // String updatedAt= rs.getString("updatedAt");
                // Float totalPrice = rs.getFloat("totalPrice");
                // int totalQuantity = rs.getInt("totalQuantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantity;
    }
    
    public int checkClothesitem(Cart cart, ClothesItem clothes) {
        // Step 1: Establishing a Connection
    	int quantity = 0;
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_CITEM_CART);) {
            preparedStatement.setInt(1, cart.getID());
            preparedStatement.setInt(2, clothes.getID());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                quantity = rs.getInt("quantity");
                // String createdAt = rs.getString("createdAt");
                // String updatedAt= rs.getString("updatedAt");
                // Float totalPrice = rs.getFloat("totalPrice");
                // int totalQuantity = rs.getInt("totalQuantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantity;
    }
    
    public int checkShoesitem(Cart cart, ShoesItem shoes) {
        // Step 1: Establishing a Connection
    	int quantity = 0;
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_SITEM_CART);) {
            preparedStatement.setInt(1, cart.getID());
            preparedStatement.setInt(2, shoes.getID());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                quantity = rs.getInt("quantity");
                // String createdAt = rs.getString("createdAt");
                // String updatedAt= rs.getString("updatedAt");
                // Float totalPrice = rs.getFloat("totalPrice");
                // int totalQuantity = rs.getInt("totalQuantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantity;
    }
    
    public HashMap<Integer, Integer> getBookItemIDList(int cartID) {
        // TODO - implement CartDAOImp.addBookitem
        HashMap<Integer, Integer> bitem = new HashMap<Integer, Integer>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BITEM_CART);) {
            preparedStatement.setInt(1, cartID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                // int ID = rs.getInt("ID");
                int bookitemID = rs.getInt("bookitemID");
                int quantity = rs.getInt("quantity");
                bitem.put(bookitemID, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bitem;
    }

    /**
     * 
     * @param electronics
     */
    public HashMap<Integer, Integer> getElectronicItemIDList(int cartID) {
        // TODO - implement CartDAOImp.addElectronicItem
        HashMap<Integer, Integer> eitem = new HashMap<Integer, Integer>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EITEM_CART)) {
            preparedStatement.setInt(1, cartID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                // int ID = rs.getInt("ID");
                int elecitemID = rs.getInt("electronicitemID");
                int quantity = rs.getInt("quantity");
                eitem.put(elecitemID, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eitem;
    }

    /**
     * 
     * @param clothes
     */
    public HashMap<Integer, Integer> getClothesItemIDList(int cartID) {
        // TODO - implement CartDAOImp.addClothesItem
        HashMap<Integer, Integer> citem = new HashMap<Integer, Integer>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CITEM_CART)) {
            preparedStatement.setInt(1, cartID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                // int ID = rs.getInt("ID");
                int clothesitemID = rs.getInt("clothesitemID");
                int quantity = rs.getInt("quantity");
                citem.put(clothesitemID, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citem;
    }

    /**
     * 
     * @param shoes
     */
    public HashMap<Integer, Integer> getShoesItem(int cartID) {
        // TODO - implement CartDAOImp.addShoesItem
        HashMap<Integer, Integer> sitem = new HashMap<Integer, Integer>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SITEM_CART)) {
            preparedStatement.setInt(1, cartID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                // int ID = rs.getInt("ID");
                int shoesitemID = rs.getInt("ShoesItemID");
                int quantity = rs.getInt("quantity");
                sitem.put(shoesitemID, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sitem;
    }

    public void createCart(Cart cart) {
        System.out.println(INSERT_CART_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_SQL)) {
            preparedStatement.setInt(1, cart.getCustomer().getID());
            preparedStatement.setString(2, cart.getCreatedAt());
            preparedStatement.setString(3, cart.getUpdatedAt());
            preparedStatement.setInt(4, cart.getTotalQuantity());
            preparedStatement.setFloat(5, cart.getTotalPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCart(Cart cart, float price, int quantity) {
        System.out.println(UPDATE_CART_BY_ID);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_BY_ID)) {
            preparedStatement.setFloat(1, price);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setInt(3, cart.getID());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cart findCart(int customerID) {
        Cart cart = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_ID);) {
            preparedStatement.setInt(1, customerID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                // String createdAt = rs.getString("createdAt");
                // String updatedAt= rs.getString("updatedAt");
                // Float totalPrice = rs.getFloat("totalPrice");
                // int totalQuantity = rs.getInt("totalQuantity");
                CustomerDAOImp cusdao = new CustomerDAOImp();
                Customer customer = cusdao.viewCustomer(customerID);
                cart = new Cart(ID, customer, "", "", 0, 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }
}