package controller.orderDAO;

import model.order.Order;

public interface orderDAO {

	public void insertOrder(Order ord);
	
	public Order getOrder(int ID);
	
	void findAllOrder();

	void getShipment();

	void getPayment();

	void getCart();

	void viewCustomer();
	
	public int getMaxID();

}