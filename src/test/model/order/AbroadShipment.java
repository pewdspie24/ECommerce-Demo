package model.order;

public class AbroadShipment extends Shipment {

	private int ID;
	private String country;
	private float tax;

	public int getID() {
		// TODO - implement AbroadShipment.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement AbroadShipment.setID
		throw new UnsupportedOperationException();
	}

	public String getCountry() {
		return this.country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	public float getTax() {
		return this.tax;
	}

	/**
	 * 
	 * @param tax
	 */
	public void setTax(float tax) {
		this.tax = tax;
	}

}