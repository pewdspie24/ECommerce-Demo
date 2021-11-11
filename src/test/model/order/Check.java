package model.order;

public class Check extends Payment {

	private int ID;
	private String name;
	private String bankID;

	public int getID() {
		// TODO - implement Check.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Check.setID
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

	public String getBankID() {
		return this.bankID;
	}

	/**
	 * 
	 * @param bankID
	 */
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

}