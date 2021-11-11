package model.book;

public class Publisher {

	private int ID;
	private String address;
	private String name;
	private String yearsOfPublish;

	public int getID() {
		// TODO - implement Publisher.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Publisher.setID
		throw new UnsupportedOperationException();
	}

	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
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

	public String getYearsOfPublish() {
		return this.yearsOfPublish;
	}

	/**
	 * 
	 * @param yearsOfPublish
	 */
	public void setYearsOfPublish(String yearsOfPublish) {
		this.yearsOfPublish = yearsOfPublish;
	}

}