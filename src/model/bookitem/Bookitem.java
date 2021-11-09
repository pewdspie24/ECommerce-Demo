package model.bookitem;

import model.book.Book;
import model.cart.Cart;

public class Bookitem {

	Book Book;
	private int ID;
	private Book book;
	private Cart cart;
	private int numbers;
	private float totalPrice;
	
	public Bookitem(int ID, model.book.Book book, model.cart.Cart cart, int numbers, float totalPrice) {
		super();
		this.book = book;
		this.cart = cart;
		this.ID = ID;
		this.numbers = numbers;
		this.totalPrice = this.book.getPrice()*this.numbers;
	}

	public int getID() {
		return this.ID;
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	public Book getBook() {
		return this.book;
	}

	/**
	 * 
	 * @param book
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getNumbers() {
		return this.numbers;
	}

	/**
	 * 
	 * @param numbers
	 */
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * 
	 * @param totalPrice
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}