package controller.bookDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book.Book;
import model.book.Comics;
import model.book.LightNovel;
import model.book.Magazine;
import model.book.Publisher;

public class BookDAOImp implements BookDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String SELECT_CM_BY_ID = "select * from book where id =?;";
    private static final String SELECT_MG_BY_ID = "select * from book where id =?;";
    private static final String SELECT_LN_BY_ID = "select * from book where id =?;";
    private static final String CHECK_TYPES_LN = "select * from book where id =? and id2 is not null;";
    private static final String CHECK_TYPES_CM = "select * from book where id =? and id3 is not null;";
    private static final String CHECK_TYPES_MG = "select * from book where id =? and id4 is not null;";
    private static final String SELECT_ALL_COMICS = "select * from book where id3 is not null;";
    private static final String SELECT_ALL_LNS = "select * from book where id2 is not null;";
    private static final String SELECT_ALL_MAGAZINES = "select * from book where id4 is not null;";
    private static final String SELECT_PUB_BY_ID = "select * from publisher where id =?";
    
    public BookDAOImp() {}
    
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
    
	public void insertBook() {
		// TODO - implement bookDAOImp.insertBook
		throw new UnsupportedOperationException();
	}

	public void deleteBook() {
		// TODO - implement bookDAOImp.deleteBook
		throw new UnsupportedOperationException();
	}

	public void updateBook() {
		// TODO - implement bookDAOImp.updateBook
		throw new UnsupportedOperationException();
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
                String yearsOfPublish = rs.getString("yearofpublish");
                pub = new Publisher(iD, address, name, yearsOfPublish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pub;
	}
	
	public List <Comics> findAllComics() {
		List < Comics > books = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMICS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int publisherID = rs.getInt("PublisherID");
                Publisher publisher = getPublisher(publisherID);
                String isbn = rs.getString("ISBN");
                String title = rs.getString("title");
                int numberOfPage = rs.getInt("numberOfPage");
                String summary = rs.getString("summary");
                int year = rs.getInt("year");
                int ID2 = rs.getInt("ID3");
                String nameComics = rs.getString("nameComics");
                String seriesName = rs.getString("seriesName");
                String artist = rs.getString("artist");
                books.add(new Comics(ID, publisher, isbn, title, numberOfPage, summary, year, ID2, nameComics, seriesName, artist));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
	}
	
	public List <LightNovel> findAllLN() {
		List < LightNovel > books = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LNS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                int publisherID = rs.getInt("PublisherID");
                Publisher publisher = getPublisher(publisherID);
                String isbn = rs.getString("ISBN");
                String title = rs.getString("title");
                int numberOfPage = rs.getInt("numberOfPage");
                String summary = rs.getString("summary");
                int year = rs.getInt("year");
                int ID2 = rs.getInt("ID2");
                String national = rs.getString("national");
                String translateLanguage = rs.getString("translateLanguage");
                String seasons = rs.getString("seasons");
                books.add(new LightNovel(ID, publisher, isbn, title, numberOfPage, summary, year, ID2, national, translateLanguage, seasons));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
	}
	
	public List <Magazine> findAllMagazine() {
		List < Magazine > books = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MAGAZINES);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	int ID = rs.getInt("ID");
                int publisherID = rs.getInt("PublisherID");
                Publisher publisher = getPublisher(publisherID);
                String isbn = rs.getString("ISBN");
                String title = rs.getString("title");
                int numberOfPage = rs.getInt("numberOfPage");
                String summary = rs.getString("summary");
                int year = rs.getInt("year");
                int ID2 = rs.getInt("ID4");
                String nameBook = rs.getString("nameBook");
                String months = rs.getString("months");
                String type = rs.getString("type");
                books.add(new Magazine(ID, publisher, isbn, title, numberOfPage, summary, year, ID2, nameBook, months, type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
	}
	
	public int checkType(int ID){
		int flag = 0;
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_LN);) {
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
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_CM);) {
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
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_MG);) {
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
	
	public Comics findComicByID(int ID) {
		Comics comics = null;
        // Step 1: Establishing a Connection
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CM_BY_ID);) {
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
	                int iD2 = rs.getInt("ID3");
	                String nameComics = rs.getString("nameComics");
	                String seriesName = rs.getString("seriesName");
	                String artist = rs.getString("artist");
	                comics = new Comics(iD, publisher, isbn, title, numberOfPage, summary, year, iD2, nameComics, seriesName, artist);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return comics;
	}
	
	public LightNovel findLNByID(int ID){
		LightNovel ln = null;
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LN_BY_ID);) {
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
	                int ID2 = rs.getInt("ID2");
	                String national = rs.getString("national");
	                String translateLanguage = rs.getString("translateLanguage");
	                String seasons = rs.getString("seasons");
	                ln = new LightNovel(iD, publisher, isbn, title, numberOfPage, summary, year, ID2, national, translateLanguage, seasons);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ln;
	}
	
	public Magazine findMagazineByID(int ID){
		Magazine magazine = null;
		try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MG_BY_ID);) {
				preparedStatement.setInt(1, ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	            	int id = rs.getInt("ID");
	                int publisherID = rs.getInt("PublisherID");
	                Publisher publisher = getPublisher(publisherID);
	                String isbn = rs.getString("ISBN");
	                String title = rs.getString("title");
	                int numberOfPage = rs.getInt("numberOfPage");
	                String summary = rs.getString("summary");
	                int year = rs.getInt("year");
	                int ID2 = rs.getInt("ID4");
	                String nameBook = rs.getString("nameBook");
	                String months = rs.getString("months");
	                String type = rs.getString("type");
	                magazine = new Magazine(id, publisher, isbn, title, numberOfPage, summary, year, ID2, nameBook, months, type);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return magazine;
	}

}
