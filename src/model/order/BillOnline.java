package model.order;

import model.customer.Customer;

public class BillOnline {

	private int ID;
	private Customer customer;
	private Order order;
	private float totalPrice;
	private String dateCreate;
	private float totalDiscount;

	public BillOnline(int iD, Customer customer, Order order, float totalPrice, String dateCreate,
			float totalDiscount) {
		super();
		ID = iD;
		this.customer = customer;
		this.order = order;
		this.totalPrice = totalPrice;
		this.dateCreate = dateCreate;
		this.totalDiscount = totalDiscount;
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

	public String getDateCreate() {
		return this.dateCreate;
	}

	/**
	 * 
	 * @param dateCreate
	 */
	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}

	public float getTotalDiscount() {
		return this.totalDiscount;
	}

	/**
	 * 
	 * @param totalDiscount
	 */
	public void setTotalDiscount(float totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public Order getOrder() {
		return this.order;
	}

	/**
	 * 
	 * @param order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

}