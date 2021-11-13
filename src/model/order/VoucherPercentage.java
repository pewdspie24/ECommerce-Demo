package model.order;

public class VoucherPercentage extends Voucher {

	private int ID;
	private int percentage;

	public VoucherPercentage(int iD, String name, String expiresDate, int iD2, int percentage) {
		super(iD, name, expiresDate);
		ID = iD2;
		this.percentage = percentage;
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

	public int getPercentage() {
		return this.percentage;
	}

	/**
	 * 
	 * @param percentage
	 */
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

}