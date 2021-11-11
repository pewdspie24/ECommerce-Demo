package model.book;

public class BookItem {

	private int ID;
	private int inStock;
	private float price;
	private float discount;
	private String date;

	public int getID() {
		// TODO - implement BookItem.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement BookItem.setID
		throw new UnsupportedOperationException();
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