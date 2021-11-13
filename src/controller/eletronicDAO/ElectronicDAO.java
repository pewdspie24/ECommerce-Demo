package controller.eletronicDAO;

import java.util.List;

import model.electronic.Computer;
import model.electronic.Laptop;
import model.electronic.MobilePhone;

public interface ElectronicDAO {

	void addElectronic();

	void deleteElectronic();

	void updateElectronic();
	
	public List <MobilePhone> findAllMobiles();
	
	public List <Laptop> findAllLaptops();
	
	public List <Computer> findAllComputers();
	
	public int checkType(int ID);
	
	public MobilePhone findMobileByID(int ID);
	
	public Laptop findLaptopByID(int ID);
	
	public Computer findComputerByID(int ID);
}