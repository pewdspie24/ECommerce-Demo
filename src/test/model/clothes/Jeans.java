package model.clothes;

public class Jeans extends Clothes {

	private int ID;
	private String type;
	private String length;
	private String pocketAvailable;

	public int getID() {
		// TODO - implement Jeans.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Jeans.setID
		throw new UnsupportedOperationException();
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

	public String getLength() {
		return this.length;
	}

	/**
	 * 
	 * @param length
	 */
	public void setLength(String length) {
		this.length = length;
	}

	public String getPocketAvailable() {
		return this.pocketAvailable;
	}

	/**
	 * 
	 * @param pocketAvailable
	 */
	public void setPocketAvailable(String pocketAvailable) {
		this.pocketAvailable = pocketAvailable;
	}

}