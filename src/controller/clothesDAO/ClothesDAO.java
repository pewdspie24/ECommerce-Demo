package controller.clothesDAO;

import java.util.List;

import model.clothes.Short;
import model.clothes.Jeans;
import model.clothes.Shirt;

public interface ClothesDAO {

	void insertClothes();

	void deleteClothes();

	void updateClothes();

	public List <Shirt> findAllShirt();
	
	public List <Jeans> findAllJeans();
	
	public List <Short> findAllShort();
	
	public int checkType(int ID);
	
	public Shirt findShirtByID(int ID);
	
	public Jeans findJeansByID(int ID);
	
	public Short findShortByID(int ID);

}