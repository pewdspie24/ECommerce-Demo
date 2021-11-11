package model.customer;

public class Phone {

	private int ID;
	private String statesNo;
	private String number;

	
	public Phone(int iD, String statesNo, String number) {
		super();
		ID = iD;
		this.statesNo = statesNo;
		this.number = number;
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

	public String getStatesNo() {
		return this.statesNo;
	}

	/**
	 * 
	 * @param statesNo
	 */
	public void setStatesNo(String statesNo) {
		this.statesNo = statesNo;
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

}