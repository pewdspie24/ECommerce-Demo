package controller.eletronicDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.electronic.Computer;
import model.electronic.Laptop;
import model.electronic.ManufacturerElectronics;
import model.electronic.MobilePhone;

public class ElectronicDAOImp implements ElectronicDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinestore?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    
    private static final String SELECT_LAPTOP_BY_ID = "select * from electronic where id =?;";
    private static final String SELECT_COMPUTER_BY_ID = "select * from electronic where id =?;";
    private static final String SELECT_MOBILE_BY_ID = "select * from electronic where id =?;";
    private static final String CHECK_TYPES_MOBILE = "select * from electronic where id =? and id2 is not null;";
    private static final String CHECK_TYPES_LAPTOP = "select * from electronic where id =? and id3 is not null;";
    private static final String CHECK_TYPES_COMPUTER = "select * from electronic where id =? and id4 is not null;";
    private static final String SELECT_ALL_MOBILE = "select * from electronic where id2 is not null;";
    private static final String SELECT_ALL_LAPTOP = "select * from electronic where id3 is not null;";
    private static final String SELECT_ALL_COMPUTER = "select * from electronic where id4 is not null;";
    private static final String SELECT_MAN_BY_ID = "select * from ManufacturerElectronics where id =?";
    
	public ElectronicDAOImp() {}
	
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
	
	public void addElectronic() {
		// TODO - implement ElectronicDAOImp.addElectronic
		throw new UnsupportedOperationException();
	}

	public void deleteElectronic() {
		// TODO - implement ElectronicDAOImp.deleteElectronic
		throw new UnsupportedOperationException();
	}

	public void updateElectronic() {
		// TODO - implement ElectronicDAOImp.updateElectronic
		throw new UnsupportedOperationException();
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
	
	public List <MobilePhone> findAllMobiles() {
		List < MobilePhone > mobile = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOBILE);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerElectronicsID");
                ManufacturerElectronics man = getManufacturerElectronics(manID);
                String name = rs.getString("name");
                int year = rs.getInt("year");
                String certificates = rs.getString("certificates");
                String safetyClaims = rs.getString("safetyClaims");
                int iD2 = rs.getInt("ID2");
                String storage = rs.getString("storage");
                String RAM = rs.getString("RAM");
                String operationSystem = rs.getString("operationSystem");
            	float screenWidth = rs.getFloat("screenWidth");
            	String resolution = rs.getString("resolution");
            	Boolean touchable = rs.getBoolean("touchable");
                mobile.add(new MobilePhone(ID, man, name, year, certificates, safetyClaims, iD2, storage, RAM, operationSystem, screenWidth, resolution, touchable));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobile;
	}
	
	public List <Laptop> findAllLaptops() {
		List < Laptop > laptop = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LAPTOP);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerElectronicsID");
                ManufacturerElectronics man = getManufacturerElectronics(manID);
                String name = rs.getString("name");
                int year = rs.getInt("year");
                String certificates = rs.getString("certificates");
                String safetyClaims = rs.getString("safetyClaims");
                int iD2 = rs.getInt("ID3");
                String disk = rs.getString("disk");
                String RAM = rs.getString("RAM2");
                String operationSystem = rs.getString("operationSystem2");
            	float screenWidth = rs.getFloat("screenWidth2");
            	String resolution = rs.getString("resolution2");
            	Boolean touchable = rs.getBoolean("touchable2");
            	laptop.add(new Laptop(ID, man, name, year, certificates, safetyClaims, iD2, screenWidth, resolution, disk, RAM, operationSystem, touchable));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptop;
	}
	
	public List <Computer> findAllComputers() {
		List < Computer > computer = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMPUTER);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int manID = rs.getInt("ManufacturerElectronicsID");
                ManufacturerElectronics man = getManufacturerElectronics(manID);
                String name = rs.getString("name");
                int year = rs.getInt("year");
                String certificates = rs.getString("certificates");
                String safetyClaims = rs.getString("safetyClaims");
                int iD2 = rs.getInt("ID4");
                String disk = rs.getString("disk2");
                String RAM = rs.getString("RAM3");
                String operationSystem = rs.getString("operationSystem3");
            	computer.add(new Computer(ID, man, name, year, certificates, safetyClaims, iD2, disk, RAM, operationSystem));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computer;
	}
	
	public int checkType(int ID){
		int flag = 0;
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_MOBILE);) {
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
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_LAPTOP);) {
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
		try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(CHECK_TYPES_COMPUTER);) {
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
	
	public MobilePhone findMobileByID(int ID) {
		MobilePhone mobile = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOBILE_BY_ID);) {
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
                int iD2 = rs.getInt("ID2");
                String storage = rs.getString("storage");
                String RAM = rs.getString("RAM");
                String operationSystem = rs.getString("operationSystem");
            	float screenWidth = rs.getFloat("screenWidth");
            	String resolution = rs.getString("resolution");
            	Boolean touchable = rs.getBoolean("touchable");
                mobile = new MobilePhone(iD, man, name, year, certificates, safetyClaims, iD2, storage, RAM, operationSystem, screenWidth, resolution, touchable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobile;
	}
	
	public Laptop findLaptopByID(int ID) {
		Laptop laptop = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAPTOP_BY_ID);) {
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
                int iD2 = rs.getInt("ID3");
                String disk = rs.getString("disk");
                String RAM = rs.getString("RAM2");
                String operationSystem = rs.getString("operationSystem2");
            	float screenWidth = rs.getFloat("screenWidth2");
            	String resolution = rs.getString("resolution2");
            	Boolean touchable = rs.getBoolean("touchable2");
            	laptop = new Laptop(iD, man, name, year, certificates, safetyClaims, iD2, screenWidth, resolution, disk, RAM, operationSystem, touchable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptop;
	}
	
	public Computer findComputerByID(int ID) {
		Computer computer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMPUTER_BY_ID);) {
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
                int iD2 = rs.getInt("ID4");
                String disk = rs.getString("disk2");
                String RAM = rs.getString("RAM3");
                String operationSystem = rs.getString("operationSystem3");
            	computer = new Computer(iD, man, name, year, certificates, safetyClaims, iD2, disk, RAM, operationSystem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computer;
	}
	
	
}