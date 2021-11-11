package model.order;

public class Voucher {

	private int ID;
	private String name;
	private String expiresDate;

	public int getID() {
		// TODO - implement Voucher.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Voucher.setID
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getExpiresDate() {
		return this.expiresDate;
	}

	/**
	 * 
	 * @param expiresDate
	 */
	public void setExpiresDate(String expiresDate) {
		this.expiresDate = expiresDate;
	}

}