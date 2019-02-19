package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.OrderMethod;
import com.app.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public Integer saveShipment(ShipmentType shipment) {
		return (Integer)ht.save(shipment);
	}

	@Override
	public void updateShipment(ShipmentType shipment) {
		ht.update(shipment);
	}

	@Override
	public void deleteShipment(Integer id) {
		ShipmentType s=new ShipmentType();
		s.setId(id);
		ht.delete(s);
	
	}

	@Override
	public ShipmentType getOneShipment(Integer id) {
		return ht.get(ShipmentType.class, id);
	}

	@Override
	public List<ShipmentType> getAllShipments() {
		return ht.loadAll(ShipmentType.class);
	}

	@Override
	public List<ShipmentType> getShipmentsByEnabled(String enabled) {

	String hql="from "+ShipmentType.class.getName()+" where enabled=? ";
		List<ShipmentType> list=(List<ShipmentType>)ht.find(hql, enabled);
		return list;
	}

}
