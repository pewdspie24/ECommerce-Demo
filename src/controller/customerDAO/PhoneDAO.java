package controller.customerDAO;

import model.customer.Customer;
import model.customer.Phone;

public interface PhoneDAO {

	public void createPhone(Customer cus);
	
	public Phone getPhone(int ID);
	
	public int getMaxID();
	
	public void updatePhone(Customer cus, Phone pho);
}
