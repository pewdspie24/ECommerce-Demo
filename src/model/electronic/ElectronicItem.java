package model.electronic;

public class ElectronicItem {

	private int ID;
	private Electronic electronic;
	private int quantity;
	private float price;
	private float discount;
	private String date;
	
	public ElectronicItem(int iD, Electronic electronic, int quantity, float price, float discount, String date) {
		super();
		this.ID = iD;
		this.electronic = electronic;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
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
		this.ID = ID;
	}

	public Electronic getElectronic() {
		return electronic;
	}

	public void setElectronic(Electronic electronic) {
		this.electronic = electronic;
	}

	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return this.discount;
	}

	/**
	 * 
	 * @param discount
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
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

}