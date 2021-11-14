package model.order;

import model.customer.Customer;

public class Cart {

	private int ID;
	private Customer customer;
	private String createdAt;
	private String updatedAt;
	private int totalQuantity;
	private float totalPrice;

	public Cart(int iD, Customer customer, String createdAt, String updatedAt, int totalQuantity, float totalPrice) {
		super();
		this.ID = iD;
		this.customer = customer;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	/**
	 * 
	 * @param createdAt
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return this.updatedAt;
	}

	/**
	 * 
	 * @param updatedAt
	 */
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getTotalQuantity() {
		return this.totalQuantity;
	}

	/**
	 * 
	 * @param totalQuantity
	 */
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
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