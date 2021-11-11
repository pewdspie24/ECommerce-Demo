package model.order;

public class FastShipment extends Shipment {

	private int ID;
	private String city;
	private String timeDesired;

	public int getID() {
		// TODO - implement FastShipment.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement FastShipment.setID
		throw new UnsupportedOperationException();
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