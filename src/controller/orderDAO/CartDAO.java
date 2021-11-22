package controller.orderDAO;

import model.order.Cart;

import java.util.List;

import java.util.HashMap;
import model.book.*;
import model.clothes.*;
import model.shoes.*;
import model.electronic.*;

public interface CartDAO {

	/**
	 * 
	 * @param book
	 */
	void addBookitem(Cart cart, BookItem book, int quantity);

	/**
	 * 
	 * @param electronics
	 */
	void addElectronicItem(Cart cart, ElectronicItem electronic, int quantity);

	/**
	 * 
	 * @param clothes
	 */
	void addClothesItem(Cart cart, ClothesItem clothes, int quantity);

	/**
	 * 
	 * @param shoes
	 */
	void addShoesItem(Cart cart, ShoesItem shoes, int quantity);
	
	
	public void createCart(Cart cart);
	
	public void updateCart(Cart cart, float price, int quantity);

	public Cart findCart(int ID);
	
	public List <HashMap<Integer, Integer>> getBookItemIDList(int cartID);
	
	public List <HashMap<Integer, Integer>> getElectronicItemIDList(int cartID);
	
	public List <HashMap<Integer, Integer>> getClothesItemIDList(int cartID);
	
	public List <HashMap<Integer, Integer>> getShoesItem(int cartID);

}