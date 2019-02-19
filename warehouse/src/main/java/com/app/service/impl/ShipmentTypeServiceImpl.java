package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;
	
	@Transactional
	public Integer saveShipment(ShipmentType shipment) {
		return dao.saveShipment(shipment);
	}

	@Transactional
	public void updateShipment(ShipmentType shipment) {
		dao.updateShipment(shipment);
	}

	@Transactional
	public void deleteShipment(Integer id) {
		dao.deleteShipment(id);
	}

	@Transactional(readOnly=true)
	public ShipmentType getOneShipment(Integer id) {
		return dao.getOneShipment(id);
	}

	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipments() {
		return dao.getAllShipments();
	}

	@Transactional
	public List<ShipmentType> getShipmentsByEnabled(String enabled) {
		return dao.getShipmentsByEnabled(enabled);
	}

}
