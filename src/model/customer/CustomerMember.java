package model.customer;

public class CustomerMember extends Customer {

	private int ID;
	private String cardID;
	private String date;

	
	public CustomerMember(int iD, String accountNum, String gender, String birth, Account account, Fullname fullname,
			Phone phone, Address address, int iD2, String cardID, String date) {
		super(iD, accountNum, gender, birth, account, fullname, phone, address);
		this.ID = iD2;
		this.cardID = cardID;
		this.date = date;
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

	public String getCardID() {
		return this.cardID;
	}

	/**
	 * 
	 * @param cardID
	 */
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public String getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

}