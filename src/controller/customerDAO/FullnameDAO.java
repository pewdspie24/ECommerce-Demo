package controller.customerDAO;

import model.customer.Customer;
import model.customer.Fullname;

public interface FullnameDAO {
	
	public void createFN(Customer cus);
	
	public Fullname getFN(int ID);
	
	public int getMaxID();
	
	public void updateFN(Customer cus, Fullname fn);
}
