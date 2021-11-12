package model.book;

public class BookItem {

	private int ID;
	private int inStock;
	private float price;
	private float discount;
	private String date;
	
	public BookItem(int iD, int inStock, float price, float discount, String date) {
		super();
		ID = iD;
		this.inStock = inStock;
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

	public int getInStock() {
		return this.inStock;
	}

	/**
	 * 
	 * @param inStock
	 */
	public void setInStock(int inStock) {
		this.inStock = inStock;
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