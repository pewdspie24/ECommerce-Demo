package model.order;

public class Credit extends Payment {

	private int ID;
	private String number;
	private String type;
	private String expString;

	public Credit(int iD, float amount, Shipment shipment, Voucher voucher, int iD2, String number, String type,
			String expString) {
		super(iD, amount, shipment, voucher);
		ID = iD2;
		this.number = number;
		this.type = type;
		this.expString = expString;
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

	public String getNumber() {
		return this.number;
	}

	/**
	 * 
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getExpString() {
		return this.expString;
	}

	/**
	 * 
	 * @param expString
	 */
	public void setExpString(String expString) {
		this.expString = expString;
	}

}