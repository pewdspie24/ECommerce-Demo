package model.customer;

public class Address {

	private int ID;
	private String city;
	private String district;
	private int houseNo;

	public Address(int ID, String city, String district, int houseNo) {
		super();
		this.ID = ID;
		this.city = city;
		this.district = district;
		this.houseNo = houseNo;
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

	public String getCity() {
		return this.city;
	}

	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return this.district;
	}

	/**
	 * 
	 * @param district
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	public int getHouseNo() {
		return this.houseNo;
	}

	/**
	 * 
	 * @param houseNo
	 */
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	
}