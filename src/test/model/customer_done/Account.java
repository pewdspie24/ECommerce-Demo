package test.model.customer_done;

import model.cart.AccountState;

public class Account {

	private int ID;
	private String email;
	private String password;
	private String createdAt;
	private AccountState state;

	public int getID() {
		// TODO - implement Account.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Account.setID
		throw new UnsupportedOperationException();
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	/**
	 * 
	 * @param createdAt
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public AccountState getState() {
		return this.state;
	}

	/**
	 * 
	 * @param state
	 */
	public void setState(AccountState state) {
		this.state = state;
	}

}