package controller.customerDAO;

import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;

public interface CustomerDAO {

	void insertCustomer(Customer customer);

	void findAllCustomer();

	void findByID();

	Account getAccount(int ID);

	Address getAddress(int ID);

	Customer viewCustomer(int ID);
	
	public int getCustomerID(int accountID);
	
	public int getMaxID();
}
