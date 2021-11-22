package controller.customerDAO;

import model.customer.Account;
import model.customer.Customer;

public interface AccountDAO {
	
	public void createAccount(Account account);
	
	public Account getAccount(int ID);
	
	public boolean validateAccount(String username, String password);
	
	public int getMaxID();
	
	public int getAccountID(String username, String password);
	
}
