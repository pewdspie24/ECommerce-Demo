package logicApplication.orderDAO;

import model.book.*;
import model.clothes.*;
import model.shoes.*;

public interface CartDAO {

	void showCart();

	/**
	 * 
	 * @param book
	 */
	void addBookitem(BookItem book);

	/**
	 * 
	 * @param electronics
	 */
	void addElectronicItem(ElectronicsItem electronics);

	/**
	 * 
	 * @param clothes
	 */
	void addClothesItem(ClothesItem clothes);

	/**
	 * 
	 * @param shoes
	 */
	void addShoesItem(ShoesItem shoes);

}