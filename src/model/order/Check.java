package model.order;

public class Check extends Payment {

	private int ID;
	private String name;
	private String bankID;

	public Check(int iD, float amount, Shipment shipment, Voucher voucher, int iD2, String name, String bankID) {
		super(iD, amount, shipment, voucher);
		ID = iD2;
		this.name = name;
		this.bankID = bankID;
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

	public String getBankID() {
		return this.bankID;
	}

	/**
	 * 
	 * @param bankID
	 */
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

}