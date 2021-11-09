package model.payment;

public class Payment {

	private int ID;
	private String methodName;
	private int discount;

	public Payment(int ID, String methodName, int discount) {
		super();
		this.ID = ID;
		this.methodName = methodName;
		this.discount = discount;
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

	public String getMethodName() {
		return this.methodName;
	}

	/**
	 * 
	 * @param methodName
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public int getDiscount() {
		return this.discount;
	}

	/**
	 * 
	 * @param discount
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

}