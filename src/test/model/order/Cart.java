package model.order;

public class Cart {

	private int ID;
	private String createdAt;
	private String updatedAt;
	private int totalQuantity;
	private float totalPrice;

	public int getID() {
		// TODO - implement Cart.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Cart.setID
		throw new UnsupportedOperationException();
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