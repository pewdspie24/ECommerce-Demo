package controller.customerDAO;

import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;

public interface customerDAO {

	void updateCustomer(Customer customer);

	void findAllCustomer();

	void findByID();

	Account getAccount(int ID);

	Address getAddress(int ID);

	Customer viewCustomer(int ID);
	
	public int getCusID(int accountID);
	
	public int getMaxID();
}