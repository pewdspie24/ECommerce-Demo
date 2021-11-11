package model.order;

import model.cart.Cart;
import model.customer.Customer;
import model.payment.Payment;
import model.shipment.Shipment;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Order {

	private int ID;
	private Customer customer;
	private Cart cart;
	private Shipment shipment;
	private Payment payment;
	private float totalPrice;
	private int totalDiscount;
	private String dateTime;
	
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	
	public Order(int ID, Customer customer, Cart cart, Shipment shipment, Payment payment, float totalPrice,
			int totalDiscount, String dateTime) {
		super();
		this.ID = ID;
		this.customer = customer;
		this.cart = cart;
		this.shipment = shipment;
		this.payment = payment;
		this.totalPrice = this.cart.getCartPrice()-this.payment.getDiscount()+this.shipment.getShipmentPrice();
		this.totalDiscount = this.payment.getDiscount();
		this.dateTime = now();
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
		return this.customer;
	}

	/**
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cart getCart() {
		return this.cart;
	}

	/**
	 * 
	 * @param cart
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Shipment getShipment() {
		return this.shipment;
	}

	/**
	 * 
	 * @param shipment
	 */
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Payment getPayment() {
		return this.payment;
	}

	/**
	 * 
	 * @param payment
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
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

	public String getDateTime() {
		return this.dateTime;
	}

	/**
	 * 
	 * @param dateTime
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}
}