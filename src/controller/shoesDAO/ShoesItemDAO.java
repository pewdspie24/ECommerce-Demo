package controller.shoesDAO;

import java.util.List;

import model.shoes.ShoesItem;

public interface ShoesItemDAO {

	void addShoesItem();

	void deleteShoesItem();

	public void updateShoesItem(int ID, int numbers);

	void getAll();
	
	public List <ShoesItem> findAllSneakerItem();
	
	public List <ShoesItem> findAllBootItem();
	
	public List <ShoesItem> findAllSandalItem();
	
	public ShoesItem getShoesItemByID(int ID);
}