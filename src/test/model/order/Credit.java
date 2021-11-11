package model.order;

public class Credit extends Payment {

	private int ID;
	private String number;
	private String type;
	private String expString;

	public int getID() {
		// TODO - implement Credit.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Credit.setID
		throw new UnsupportedOperationException();
	}

	public String getNumber() {
		return this.number;
	}

	/**
	 * 
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getExpString() {
		return this.expString;
	}

	/**
	 * 
	 * @param expString
	 */
	public void setExpString(String expString) {
		this.expString = expString;
	}

}