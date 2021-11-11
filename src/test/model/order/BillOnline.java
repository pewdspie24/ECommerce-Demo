package model.order;

public class BillOnline {

	private int ID;
	private float totalPrice;
	private String dateCreate;
	private float totalDiscount;
	private Order order;

	public int getID() {
		// TODO - implement BillOnline.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement BillOnline.setID
		throw new UnsupportedOperationException();
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