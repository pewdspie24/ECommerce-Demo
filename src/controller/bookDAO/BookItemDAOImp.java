package controller.bookDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book.Book;
import model.book.BookItem;
import model.book.Publisher;

public class BookItemDAOImp implements BookItemDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL_CMITEM_ID = "SELECT * FROM bookitem WHERE BookID IN (SELECT ID FROM book WHERE ID3 is NOT NULL); ";
    private static final String SELECT_ALL_MGITEM_ID = "SELECT * FROM bookitem WHERE BookID IN (SELECT ID FROM book WHERE ID4 is NOT NULL); ";
    private static final String SELECT_ALL_LNITEM_ID = "SELECT * FROM bookitem WHERE BookID IN (SELECT ID FROM book WHERE ID2 is NOT NULL); ";
    private static final String UPDATE_BITEM_ID = "UPDATE bookitem SET instock= ? WHERE ID = ?;";
    private static final String SELECT_BITEM_ID = "select * from bookitem where id =?;";
    private static final String SELECT_BOOK_ID = "select * from book where id =?;";
    private static final String SELECT_NUM_BY_ID = "select instock from bookitem where ID = ?";
    private static final String SELECT_PUB_BY_ID = "select * from publisher where id =?";

    public BookItemDAOImp() {
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

    public int getStock(int ID) {
        int instock = 0;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NUM_BY_ID)) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                instock = rs.getInt("instock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instock;
    }

    public void addBookItem() {
        // TODO - implement BookItemDAOImp.addBookItem
        throw new UnsupportedOperationException();
    }

    public void deleteBookItem() {
        // TODO - implement BookItemDAOImp.deleteBookItem
        throw new UnsupportedOperationException();
    }

    public void updateBookItem(int ID, int numbers) {
        // TODO - implement BookItemDAOImp.updateBookItem
        int prevNum = getStock(ID);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BITEM_ID)) {
            preparedStatement.setInt(1, prevNum - numbers);
            preparedStatement.setInt(2, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Publisher getPublisher(int ID) {
        Publisher pub = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PUB_BY_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int iD = rs.getInt("ID");
                String address = rs.getString("address");
                String name = rs.getString("name");
                String yearsOfPublish = rs.getString("YearsOfPublish");
                pub = new Publisher(iD, address, name, yearsOfPublish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pub;
    }

    public Book getBookByID(int ID) {
        Book book = null;
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
                int publisherID = rs.getInt("PublisherID");
                Publisher publisher = getPublisher(publisherID);
                String isbn = rs.getString("ISBN");
                String title = rs.getString("title");
                int numberOfPage = rs.getInt("numberOfPage");
                String summary = rs.getString("summary");
                int year = rs.getInt("year");
                book = new Book(iD, publisher, isbn, title, numberOfPage, summary, year);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<BookItem> findAllComicsItem() {
        List<BookItem> books = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CMITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int BookID = rs.getInt("BookID");
                Book book = getBookByID(BookID);
                int inStock = rs.getInt("inStock");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                books.add(new BookItem(ID, book, inStock, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public List<BookItem> findAllLightNovelItem() {
        List<BookItem> books = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LNITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int BookID = rs.getInt("BookID");
                Book book = getBookByID(BookID);
                int inStock = rs.getInt("inStock");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                books.add(new BookItem(ID, book, inStock, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public List<BookItem> findAllMagazineItem() {
        List<BookItem> books = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MGITEM_ID);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int BookID = rs.getInt("BookID");
                Book book = getBookByID(BookID);
                int inStock = rs.getInt("inStock");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                books.add(new BookItem(ID, book, inStock, price, discount, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public BookItem getBookItemByID(int ID) {
        BookItem bookitem = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BITEM_ID);) {
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int iD = rs.getInt("ID");
                int BookID = rs.getInt("BookID");
                Book book = getBookByID(BookID);
                int inStock = rs.getInt("inStock");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                String date = rs.getString("date");
                bookitem = new BookItem(iD, book, inStock, price, discount, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookitem;
    }

}