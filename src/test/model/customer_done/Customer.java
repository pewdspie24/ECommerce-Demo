package test.model.customer_done;

import model.customer.Fullname;
import model.customer.Phone;

public class Customer {

	private int ID;
	private String accountNum;
	private String gender;
	private String birth;
	private Account account;
	private Fullname fullname;
	private Phone phone;
	private Address address;

	public int getID() {
		// TODO - implement Customer.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Customer.setID
		throw new UnsupportedOperationException();
	}

	public String getAccountNum() {
		return this.accountNum;
	}

	/**
	 * 
	 * @param accountNum
	 */
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getGender() {
		return this.gender;
	}

	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return this.birth;
	}

	/**
	 * 
	 * @param birth
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Account getAccount() {
		return this.account;
	}

	/**
	 * 
	 * @param account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	public Fullname getFullname() {
		return this.fullname;
	}

	/**
	 * 
	 * @param fullname
	 */
	public void setFullname(Fullname fullname) {
		this.fullname = fullname;
	}

	public Phone getPhone() {
		return this.phone;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}