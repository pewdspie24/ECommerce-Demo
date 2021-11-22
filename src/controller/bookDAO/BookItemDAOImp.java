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
            PreparedStatement p = connection.prepareStatement(
            		"CREATE TABLE Customer (ID int(10) NOT NULL AUTO_INCREMENT, Gender varchar(255), Birth varchar(255), AccountNum varchar(255), ID3 int(10), CardID varchar(255), Date2 varchar(255), ID2 int(10), `Date` varchar(255) , PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Address (ID int(10) NOT NULL AUTO_INCREMENT, CustomerID int(10) NOT NULL, Number varchar(255), Street varchar(255), District varchar(255), City varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Fullname (ID int(10) NOT NULL AUTO_INCREMENT, CustomerID int(10) NOT NULL, FirstName varchar(255), LastName varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Account (ID int(10) NOT NULL AUTO_INCREMENT, CustomerID int(10) NOT NULL, Email varchar(255), Password varchar(255), CreatedAt varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE `Order` (ID int(10) NOT NULL AUTO_INCREMENT, PaymentID int(10) NOT NULL, BillOnlineID int(10) NOT NULL, CustomerID int(10) NOT NULL, `Date` varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Cart (ID int(10) NOT NULL AUTO_INCREMENT, CustomerID int(10) NOT NULL, OrderID int(10) NOT NULL, CreatedAt varchar(255), UpdatedAt varchar(255), TotalQuantity int(10) NOT NULL, TotalPrice float NOT NULL, PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE BookItem (ID int(10) NOT NULL AUTO_INCREMENT, BookID int(10) NOT NULL, InStock int(10) NOT NULL, Price float NOT NULL, Discount float NOT NULL, `Date` varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Book (ID int(10) NOT NULL AUTO_INCREMENT, PublisherID int(10) NOT NULL, ISBN varchar(255), Title varchar(255), NumberOfPage int(10) NOT NULL, Summary varchar(255), Year int(10) NOT NULL, ID2 int(10), `National` varchar(255), TranslateLanguage varchar(255), Seasons varchar(255), ID3 int(10), NameComics varchar(255), SeriesName varchar(255), Artist varchar(255), ID4 int(10), NameBook varchar(255), Months varchar(255), Type varchar(255) , PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Author (ID int(10) NOT NULL AUTO_INCREMENT, Name varchar(255), Biography varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Publisher (ID int(10) NOT NULL AUTO_INCREMENT, Address varchar(255), Name varchar(255), YearsOfPublish varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Payment (ID int(10) NOT NULL AUTO_INCREMENT, ShipmentID int(10) NOT NULL, VoucherID int(10) NOT NULL, Amount float NOT NULL, ID2 int(10), CashTendered float, ID3 int(10), Name varchar(255), BankID varchar(255), ID4 int(10), Number varchar(255), Type varchar(255), ExpString varchar(255) , PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Shipment (ID int(10) NOT NULL AUTO_INCREMENT, Price float NOT NULL, Description varchar(255), ID4 int(10), Country varchar(255), Tax float, ID2 int(10), City varchar(255), TimeDesired varchar(255), ID3 int(10), Company varchar(255) , PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Phone (ID int(10) NOT NULL AUTO_INCREMENT, CustomerID int(10) NOT NULL, StatesNo varchar(255), Number varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Electronic (ID int(10) NOT NULL AUTO_INCREMENT, ManufacturerElectronicsID int(10) NOT NULL, Name varchar(255), Year int(10) NOT NULL, Certificates varchar(255), SafetyClaims varchar(255), ID2 int(10), Storage varchar(255), RAM varchar(255), OperationSystem varchar(255), ScreenWidth float, Resolution varchar(255), Touchable bit(1), ID3 int(10), ScreenWidth2 float, Resolution2 varchar(255), `Disk` varchar(255), RAM2 varchar(255), OperationSystem2 varchar(255), Touchable2 bit(1), ID4 int(10), Disk2 varchar(255), RAM3 varchar(255), OperationSystem3 varchar(255) , PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE ElectronicItem (ID int(10) NOT NULL AUTO_INCREMENT, ElectronicID int(10) NOT NULL, Quantity int(10) NOT NULL, Price float NOT NULL, Discount float NOT NULL, `Date` varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Clothes (ID int(10) NOT NULL AUTO_INCREMENT, ManufacturerClothesID int(10) NOT NULL, Gender varchar(255), Type varchar(255), Material varchar(255), ID3 int(10), Type3 varchar(255), Length varchar(255), PocketAvailable varchar(255), ID2 int(10), Type2 varchar(255), FashionList varchar(255), SleeveType varchar(255), ID4 int(10), Type4 varchar(255), Length2 varchar(255), Age varchar(255), FashionList2 varchar(255) , PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE ClothesItem (ID int(10) NOT NULL AUTO_INCREMENT, ClothesID int(10) NOT NULL, Quantity int(10) NOT NULL, Price float NOT NULL, Discount float NOT NULL, `Date` varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Shoes (ID int(10) NOT NULL AUTO_INCREMENT, ManufacturerShoesID int(10) NOT NULL, Gender varchar(255), Weight varchar(255), Launched varchar(255), Material varchar(255), ID2 int(10), Style varchar(255), Type varchar(255), BrandName varchar(255), ID3 int(10), Height varchar(255), Type2 varchar(255), BrandName2 varchar(255), Style2 varchar(255), FashionList varchar(255), ID4 int(10), Style3 varchar(255), Type3 varchar(255), BrandName3 varchar(255) , PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE ShoesItem (ID int(10) NOT NULL AUTO_INCREMENT, ShoesID int(10) NOT NULL, Quantity int(10) NOT NULL, Price float NOT NULL, Discount float NOT NULL, `Date` varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE ManufacturerClothes (ID int(10) NOT NULL AUTO_INCREMENT, Name varchar(255), Country varchar(255), Description varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE `Size` (ID int(10) NOT NULL AUTO_INCREMENT, VariantID int(10) NOT NULL, Sign varchar(255), `Size` int(10) NOT NULL, PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Variant (ID int(10) NOT NULL AUTO_INCREMENT, ShoesID int(10) NOT NULL, ClothesID int(10) NOT NULL, ProduceDate varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Color (ID int(10) NOT NULL AUTO_INCREMENT, VariantID int(10) NOT NULL, Name varchar(255), ColorCode varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE BillOnline (ID int(10) NOT NULL AUTO_INCREMENT, CustomerID int(10) NOT NULL, TotalPrice float NOT NULL, DateCreate varchar(255), TotalDiscount float NOT NULL, `Order` int(10), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Voucher (ID int(10) NOT NULL AUTO_INCREMENT, Name varchar(255), ExpiresDate varchar(255), ID2 int(10), Quantity float, ID3 int(10), Percentage int(10) , PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Favourite (ID int(10) NOT NULL AUTO_INCREMENT, CustomerID int(10) NOT NULL, NameItem varchar(255), Link varchar(255), TimeStamp varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE ManufacturerShoes (ID int(10) NOT NULL AUTO_INCREMENT, Name varchar(255), Country varchar(255), Description varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE ManufacturerElectronics (ID int(10) NOT NULL AUTO_INCREMENT, Name varchar(255), Country varchar(255), Description varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Report (ID int(10) NOT NULL AUTO_INCREMENT, CustomerID int(10) NOT NULL, DateCreated varchar(255), Content varchar(255), LinkProduct varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE SearchHistory (ID int(10) NOT NULL AUTO_INCREMENT, CustomerID int(10) NOT NULL, TimeStamp varchar(255), Link varchar(255), PRIMARY KEY (ID));\r\n"
            		+ "CREATE TABLE Book_Author (BookID int(10) NOT NULL, AuthorID int(10) NOT NULL, PRIMARY KEY (BookID, AuthorID));\r\n"
            		+ "CREATE TABLE BookItem_Cart (BookItemID int(10) NOT NULL, CartID int(10) NOT NULL, Quantity int(10) NOT NULL, PRIMARY KEY (BookItemID, CartID));\r\n"
            		+ "CREATE TABLE ClothesItem_Cart (ClothesItemID int(10) NOT NULL, CartID int(10) NOT NULL, Quantity int(10) NOT NULL, PRIMARY KEY (ClothesItemID, CartID));\r\n"
            		+ "CREATE TABLE ShoesItem_Cart (ShoesItemID int(10) NOT NULL, CartID int(10) NOT NULL, Quantity int(10) NOT NULL, PRIMARY KEY (ShoesItemID, CartID));\r\n"
            		+ "CREATE TABLE ElectronicItem_Cart (ElectronicItemID int(10) NOT NULL, CartID int(10) NOT NULL, Quantity int(10) NOT NULL, PRIMARY KEY (ElectronicItemID, CartID));\r\n"
            		+ "ALTER TABLE Address ADD CONSTRAINT FKAddress64710 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);\r\n"
            		+ "ALTER TABLE Fullname ADD CONSTRAINT FKFullname417515 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);\r\n"
            		+ "ALTER TABLE Account ADD CONSTRAINT FKAccount437857 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);\r\n"
            		+ "ALTER TABLE `Order` ADD CONSTRAINT FKOrder556711 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);\r\n"
            		+ "ALTER TABLE Cart ADD CONSTRAINT FKCart195823 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);\r\n"
            		+ "ALTER TABLE Cart ADD CONSTRAINT FKCart92266 FOREIGN KEY (OrderID) REFERENCES `Order` (ID);\r\n"
            		+ "ALTER TABLE BookItem ADD CONSTRAINT FKBookItem313834 FOREIGN KEY (BookID) REFERENCES Book (ID);\r\n"
            		+ "ALTER TABLE Book ADD CONSTRAINT FKBook221643 FOREIGN KEY (PublisherID) REFERENCES Publisher (ID);\r\n"
            		+ "ALTER TABLE `Order` ADD CONSTRAINT FKOrder92191 FOREIGN KEY (PaymentID) REFERENCES Payment (ID);\r\n"
            		+ "ALTER TABLE Payment ADD CONSTRAINT FKPayment767140 FOREIGN KEY (ShipmentID) REFERENCES Shipment (ID);\r\n"
            		+ "ALTER TABLE Phone ADD CONSTRAINT FKPhone193160 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);\r\n"
            		+ "ALTER TABLE ElectronicItem ADD CONSTRAINT FKElectronicItem917854 FOREIGN KEY (ElectronicID) REFERENCES Electronic(ID);\r\n"
            		+ "ALTER TABLE ClothesItem ADD CONSTRAINT FKClothesItem902277 FOREIGN KEY (ClothesID) REFERENCES Clothes (ID);\r\n"
            		+ "ALTER TABLE ShoesItem ADD CONSTRAINT FKShoesItem181756 FOREIGN KEY (ShoesID) REFERENCES Shoes (ID);\r\n"
            		+ "ALTER TABLE Clothes ADD CONSTRAINT FKClothes124338 FOREIGN KEY (ManufacturerClothesID) REFERENCES ManufacturerClothes (ID);\r\n"
            		+ "ALTER TABLE Variant ADD CONSTRAINT FKVariant761716 FOREIGN KEY (ShoesID) REFERENCES Shoes (ID);\r\n"
            		+ "ALTER TABLE Variant ADD CONSTRAINT FKVariant99014 FOREIGN KEY (ClothesID) REFERENCES Clothes (ID);\r\n"
            		+ "ALTER TABLE `Size` ADD CONSTRAINT FKSize94388 FOREIGN KEY (VariantID) REFERENCES Variant (ID);\r\n"
            		+ "ALTER TABLE Color ADD CONSTRAINT FKColor381715 FOREIGN KEY (VariantID) REFERENCES Variant (ID);\r\n"
            		+ "ALTER TABLE BillOnline ADD CONSTRAINT FKBillOnline329308 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);\r\n"
            		+ "ALTER TABLE `Order` ADD CONSTRAINT FKOrder443398 FOREIGN KEY (BillOnlineID) REFERENCES BillOnline (ID);\r\n"
            		+ "ALTER TABLE Payment ADD CONSTRAINT FKPayment180552 FOREIGN KEY (VoucherID) REFERENCES Voucher (ID);\r\n"
            		+ "ALTER TABLE Favourite ADD CONSTRAINT FKFavourite752484 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);\r\n"
            		+ "ALTER TABLE Shoes ADD CONSTRAINT FKShoes819773 FOREIGN KEY (ManufacturerShoesID) REFERENCES ManufacturerShoes (ID);\r\n"
            		+ "ALTER TABLE Electronic ADD CONSTRAINT FKElectronic702555 FOREIGN KEY (ManufacturerElectronicsID) REFERENCES ManufacturerElectronics (ID);\r\n"
            		+ "ALTER TABLE Report ADD CONSTRAINT FKReport553273 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);\r\n"
            		+ "ALTER TABLE SearchHistory ADD CONSTRAINT FKSearchHist481291 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);\r\n"
            		+ "ALTER TABLE Book_Author ADD CONSTRAINT FKBook_Autho438413 FOREIGN KEY (AuthorID) REFERENCES Author (ID);\r\n"
            		+ "ALTER TABLE Book_Author ADD CONSTRAINT FKBook_Autho139474 FOREIGN KEY (BookID) REFERENCES Book (ID);\r\n"
            		+ "ALTER TABLE BookItem_Cart ADD CONSTRAINT FKBookItem_C981214 FOREIGN KEY (CartID) REFERENCES Cart (ID);\r\n"
            		+ "ALTER TABLE BookItem_Cart ADD CONSTRAINT FKBookItem_C85651 FOREIGN KEY (BookItemID) REFERENCES BookItem (ID);\r\n"
            		+ "ALTER TABLE ClothesItem_Cart ADD CONSTRAINT FKClothesIte950639 FOREIGN KEY (CartID) REFERENCES Cart (ID);\r\n"
            		+ "ALTER TABLE ClothesItem_Cart ADD CONSTRAINT FKClothesIte448269 FOREIGN KEY (ClothesItemID) REFERENCES ClothesItem (ID);\r\n"
            		+ "ALTER TABLE ShoesItem_Cart ADD CONSTRAINT FKShoesItem_451799 FOREIGN KEY (CartID) REFERENCES Cart (ID);\r\n"
            		+ "ALTER TABLE ShoesItem_Cart ADD CONSTRAINT FKShoesItem_932303 FOREIGN KEY (ShoesItemID) REFERENCES ShoesItem (ID);\r\n"
            		+ "ALTER TABLE ElectronicItem_Cart ADD CONSTRAINT FKElectronic229915 FOREIGN KEY (CartID) REFERENCES Cart (ID);\r\n"
            		+ "ALTER TABLE ElectronicItem_Cart ADD CONSTRAINT FKElectronic476468 FOREIGN KEY (ElectronicItemID) REFERENCES ElectronicItem (ID);\r\n"
            		+ "");
            p.executeUpdate();
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
                String yearsOfPublish = rs.getString("yearofpublish");
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