package model.order;

import model.customer.Customer;

public class Order {

	private int ID;
	private Cart cart;
	private Payment payment;
	private Customer customer;
	private String date;

	public Order(int iD, Cart cart, Payment payment, Customer customer, String date) {
		super();
		this.ID = iD;
		this.cart = cart;
		this.payment = payment;
		this.customer = customer;
		this.date = date;
	}

	public int getID() {
		return this.ID;
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Order.setID
		this.ID = ID;
	}

	public String getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}