package controller.customerDAO;

import model.customer.Phone;

public interface PhoneDAO {

	public void createPhone(Phone phone);
	
	public Phone getPhone(int ID);
	
	public int getMaxID();
	
	public void updatePhone(Phone phone);
}
