package controller.customerDAO;

import model.customer.Fullname;

public interface FullnameDAO {
	
	public void createFullName(Fullname fullname);
	
	public Fullname getFullName(int ID);
	
	public int getMaxID();
	
	public void updateFullName(Fullname fullname);
}
