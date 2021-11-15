package controller.shipmentDAO;

import java.util.List;

import model.shipment.Shipment;

public interface ShipmentDAO {

	void insertShipmentMethod();

	void deleteShipmentMethod();

	void updateShipmentMethod();

	public Shipment selectShipment(int ID);

	public List<Shipment> findAllShipment();

}