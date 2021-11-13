package controller.orderDAO;

import model.order.Cart;
import model.book.*;
import model.clothes.*;
import model.shoes.*;
import model.electronic.*;

public interface CartDAO {

	/**
	 * 
	 * @param book
	 */
	void addBookitem(BookItem book);

	/**
	 * 
	 * @param electronics
	 */
	void addElectronicItem(ElectronicItem electronic);

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
	
	public void createCart(Cart cart);
	
	public void updateCart(Cart cart, float price, int quantity);

	public Cart findCart(int ID);

}