package controller.eletronicDAO;

import java.util.List;

import model.electronic.ElectronicItem;

public interface ElectronicItemDAO {

	void addElectronicItem();

	void deleteElectronicItem();

	public void updateElectronicItem(int ID, int numbers);

	void getAll();
	
	public List <ElectronicItem> findAllMobileItem();
	
	public List <ElectronicItem> findAllLaptopItem();
	
	public List <ElectronicItem> findAllComputerItem();
	
	public List <ElectronicItem> getElectronicItemByID(int ID);
}