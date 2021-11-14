package controller.orderDAO;

import java.util.List;

import model.order.VoucherPercentage;
import model.order.VoucherConstant;

public interface VoucherDAO {
	
	void insertVoucher();

	void deleteVoucher();

	void updateVoucher();

	public List <VoucherConstant> findAllVoucherConstant();
	
	public List <VoucherPercentage> findAllVoucherPercentage();
	
	public int checkType(int ID);
	
	public VoucherConstant findVoucherConstantByID(int ID);
	
	public VoucherPercentage findVoucherPercentageByID(int ID);
}
