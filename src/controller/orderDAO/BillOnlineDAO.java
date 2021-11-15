package controller.orderDAO;

import java.util.List;

import model.order.BillOnline;

public interface BillOnlineDAO {

	public void insertBill(BillOnline bill);
	
	public BillOnline getBill(int ID);
	
	public int getMaxID();
	
	public List <BillOnline> findAllBill();
}
