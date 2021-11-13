package model.order;

public class AbroadShipment extends Shipment {

	private int ID;
	private String country;
	private float tax;
	
	public AbroadShipment(int iD, float price, String description, int iD2, String country, float tax) {
		super(iD, price, description);
		ID = iD2;
		this.country = country;
		this.tax = tax;
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