package controller.addressDAO;

import model.customer.Address;

public interface addressDAO {
	public void insertAddress(Address add);
	public boolean deleteAddress(int ID);
	public Address getAddress(int ID);
	public int getMaxID();
}
