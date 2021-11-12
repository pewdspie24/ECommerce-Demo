package controller.clothesDAO;

import java.util.List;

import model.clothes.ClothesItem;

public interface ClothesItemDAO {
	
	void addClothesItem();

	void deleteClothesItem();

	public void updateClothesItem(int ID, int numbers);
	
	public List <ClothesItem> findAllShortItem();
	
	public List <ClothesItem> findAllJeansItem();
	
	public List <ClothesItem> findAllShirtItem();
	
	public ClothesItem getClothesItemByID(int ID);
}