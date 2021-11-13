package model.order;

public class Voucher {

	private int ID;
	private String name;
	private String expiresDate;

	public Voucher(int iD, String name, String expiresDate) {
		super();
		ID = iD;
		this.name = name;
		this.expiresDate = expiresDate;
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