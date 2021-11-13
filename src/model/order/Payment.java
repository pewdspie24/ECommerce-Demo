package model.order;

public class Payment {

	private int ID;
	private float amount;
	private Shipment shipment;
	private Voucher voucher;
	
	public Payment(int iD, float amount, Shipment shipment, Voucher voucher) {
		super();
		ID = iD;
		this.amount = amount;
		this.shipment = shipment;
		this.voucher = voucher;
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

	public float getAmount() {
		return this.amount;
	}

	/**
	 * 
	 * @param total
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

}