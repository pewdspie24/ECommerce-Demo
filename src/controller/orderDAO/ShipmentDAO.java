package controller.orderDAO;

import java.util.List;

import model.order.EconomicalShipment;
import model.order.FastShipment;
import model.order.AbroadShipment;

public interface ShipmentDAO {
	
	void insertShipment();

	void deleteShipment();

	void updateShipment();

	public List <FastShipment> findAllFastShipment();
	
	public List <EconomicalShipment> findAllEconomicalShipment();
	
	public List <AbroadShipment> findAllAbroadShipment();
	
	public int checkType(int ID);
	
	public FastShipment findFastShipmentByID(int ID);
	
	public EconomicalShipment findEconomicalShipmentByID(int ID);
	
	public AbroadShipment findAbroadShipmentByID(int ID);
}
