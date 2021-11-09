package model.cart;

import model.customer.Customer;

public class Cart {

	private int ID;
	private float cartPrice;
	private int totalDiscount;
	private Customer customer;

	public Cart(int ID, Customer customer, float cartPrice, int totalDiscount) {
		super();
		this.ID = ID;
		this.cartPrice = cartPrice;
		this.totalDiscount = totalDiscount;
		this.customer = customer;
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

	public float getCartPrice() {
		return this.cartPrice;
	}

	/**
	 * 
	 * @param cartPrice
	 */
	public void setCartPrice(float cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getTotalDiscount() {
		return this.totalDiscount;
	}

	/**
	 * 
	 * @param totalDiscount
	 */
	public void setTotalDiscount(int totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	/**
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}