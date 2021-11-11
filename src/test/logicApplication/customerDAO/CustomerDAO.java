package logicApplication.customerDAO;

import model.order.*;

public interface CustomerDAO {

	void updateCustomer();

	/**
	 * 
	 * @param order
	 */
	void viewOrder(Order order);

	void addCustomer();

	/**
	 * 
	 * @param Bill
	 */
	void viewBill(int Bill);

}