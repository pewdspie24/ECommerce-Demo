package controller.customerDAO;

import model.customer.Account;
import model.customer.Customer;

public interface AccountDAO {
	
	public void createAccount(Customer cus);
	
	public Account getAccount(int ID);
	
	public boolean validateAccount(String username, String password);
	
	public int getMaxID();
	
	public int getAccID(String username, String password);
	
}
