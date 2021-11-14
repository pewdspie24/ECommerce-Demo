package model.order;

public class EconomicalShipment extends Shipment {

	private int ID;
	private String company;

	public EconomicalShipment(int iD, float price, String description, int iD2, String company) {
		super(iD, price, description);
		ID = iD2;
		this.company = company;
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

}