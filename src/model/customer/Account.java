package model.customer;

public class Account {

	private int ID;
	private String email;
	private String password;
	private String createdAt;
	public Account(int iD, String email, String password, String createdAt) {
		super();
		this.ID = iD;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}