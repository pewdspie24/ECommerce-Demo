package model.book;

public class Publisher {

	private int ID;
	private String address;
	private String name;
	private String yearsOfPublish;

	public Publisher(int iD, String address, String name, String yearsOfPublish) {
		super();
		ID = iD;
		this.address = address;
		this.name = name;
		this.yearsOfPublish = yearsOfPublish;
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