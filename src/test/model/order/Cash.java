package model.order;

public class Cash extends Payment {

	private int ID;
	private float cashTendered;

	public int getID() {
		// TODO - implement Cash.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Cash.setID
		throw new UnsupportedOperationException();
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