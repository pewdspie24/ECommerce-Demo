package model.customer;

public class Customer {

	private int ID;
	private String name;
	private String gender;
	private int age;
	private Address address;
	private Account account;
	private String phoneNum;
	private String email;
	private String accountNum;
	
	public Customer(int ID,  String name,
			String gender, int age, model.customer.Address address, model.customer.Account account, String phoneNum,
			String email, String accountNum) {
		super();
		this.ID = ID;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.account = account;
		this.phoneNum = phoneNum;
		this.email = email;
		this.accountNum = accountNum;
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

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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

	public int getAge() {
		return this.age;
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
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

	public String getPhoneNum() {
		return this.phoneNum;
	}

	/**
	 * 
	 * @param phoneNum
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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

}