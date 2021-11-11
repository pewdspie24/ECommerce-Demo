package controller.customerDAO;

import model.customer.Address;
import model.customer.Customer;

public interface addressDAO {
	public void insertAddress(Customer cus);
	public boolean deleteAddress(int ID);
	public Address getAddress(int ID);
	public int getMaxID();
}
