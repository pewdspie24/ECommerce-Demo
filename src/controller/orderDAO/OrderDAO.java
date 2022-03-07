package controller.orderDAO;

import java.util.List;

import model.order.Order;

public interface OrderDAO {

	public void insertOrder(Order ord);
	
	public Order getOrder(int ID);
	
	public List <Order> findAllOrder();

	void getShipment();

	void getPayment();

	void getCart();

	void viewCustomer();
	
	public int getMaxID();

}
