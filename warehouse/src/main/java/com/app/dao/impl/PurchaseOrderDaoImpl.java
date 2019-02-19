package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;

@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveOrder(PurchaseOrder po) {
		return (Integer)ht.save(po);
	}

	@Override
	public void updateOrder(PurchaseOrder po) {
		ht.update(po);
	}

	@Override
	public void deleteOrder(Integer id) {
			PurchaseOrder por=new PurchaseOrder();
			por.setId(id);
			ht.delete(por);
	}

	@Override
	public PurchaseOrder getOneOrder(Integer id) {
		return ht.get(PurchaseOrder.class, id);
	}

	@Override
	public List<PurchaseOrder> getAllOrders() {
		return ht.loadAll(PurchaseOrder.class);
	}

}
