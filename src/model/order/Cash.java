package model.order;

public class Cash extends Payment {

	private int ID;
	private float cashTendered;

	public Cash(int iD, float amount, Shipment shipment, Voucher voucher, int iD2, float cashTendered) {
		super(iD, amount, shipment, voucher);
		ID = iD2;
		this.cashTendered = cashTendered;
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

	public float getCashTendered() {
		return this.cashTendered;
	}

	/**
	 * 
	 * @param cashTendered
	 */
	public void setCashTendered(float cashTendered) {
		this.cashTendered = cashTendered;
	}

}