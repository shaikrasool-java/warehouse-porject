package com.app.dao;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeDao {

	public Integer saveShipment(ShipmentType shipment);
	public void updateShipment(ShipmentType shipment);
	public void deleteShipment(Integer id);
	public ShipmentType getOneShipment(Integer id);
	public List<ShipmentType> getAllShipments();
	public List<ShipmentType> getShipmentsByEnabled(String enabled);
	
}
