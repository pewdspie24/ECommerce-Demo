package mode.shipment;

public class Shipment {

	private int ID;
	private String company;
	private float shipmentPrice;

	public Shipment(int ID, String company, float shipmentPrice) {
		super();
		this.ID = ID;
		this.company = company;
		this.shipmentPrice = shipmentPrice;
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

	public String getCompany() {
		return this.company;
	}

	/**
	 * 
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	public float getShipmentPrice() {
		return this.shipmentPrice;
	}

	/**
	 * 
	 * @param shipmentPrice
	 */
	public void setShipmentPrice(float shipmentPrice) {
		this.shipmentPrice = shipmentPrice;
	}

}