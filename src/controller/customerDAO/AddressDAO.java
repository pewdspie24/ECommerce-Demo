package controller.customerDAO;

import model.customer.Address;
import model.customer.Customer;

public interface AddressDAO {
	public void insertAddress(Address address);
	public boolean deleteAddress(int ID);
	public Address getAddress(int ID);
	public int getMaxID();
}
