package model.customer;

public class CustomerNew extends Customer {

	private int ID;
	private String date;

	public CustomerNew(int iD, String accountNum, String gender, String birth, Account account, Fullname fullname,
			Phone phone, Address address, int iD2, String date) {
		super(iD, accountNum, gender, birth, account, fullname, phone, address);
		this.ID = iD2;
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