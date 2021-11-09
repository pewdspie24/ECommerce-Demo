package controller.accountDAO;

import model.customer.Account;

public interface accountDAO {
	
	public void createAccount(Account acc);
	
	public Account getAccount(int ID);
	
	public boolean validateAccount(String username, String password);
	
	public int getMaxID();
	
	public int getAccID(String username, String password);
	
}
