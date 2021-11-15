package controller.orderDAO;

import java.util.List;

import model.order.Check;
import model.order.Cash;
import model.order.Credit;
import model.order.Payment;

public interface PaymentDAO {

	public Payment getPaymentByID(int ID);

	void createPayment();

	void updatePayment();
	
	public List <Cash> findAllCash();
	
	public List <Check> findAllCheck();
	
	public List <Credit> findAllCredit();
	
	public int checkType(int ID);
	
	public Cash findCashByID(int ID);
	
	public Check findCheckByID(int ID);
	
	public Credit findCreditByID(int ID);
}