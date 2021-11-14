package model.order;

public class FastShipment extends Shipment {

	private int ID;
	private String city;
	private String timeDesired;

	public FastShipment(int iD, float price, String description, int iD2, String city, String timeDesired) {
		super(iD, price, description);
		ID = iD2;
		this.city = city;
		this.timeDesired = timeDesired;
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

	public String getTimeDesired() {
		return this.timeDesired;
	}

	/**
	 * 
	 * @param timeDesired
	 */
	public void setTimeDesired(String timeDesired) {
		this.timeDesired = timeDesired;
	}

}