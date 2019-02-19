package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService{


	@Autowired
	private IPurchaseOrderDao dao;

	@Transactional
	public Integer saveOrder(PurchaseOrder po) {
		return dao.saveOrder(po);
	}

	@Transactional
	public void updateOrder(PurchaseOrder po) {
		dao.updateOrder(po);
	}

	@Transactional
	public void deleteOrder(Integer id) {
		dao.deleteOrder(id);
	}

	@Transactional(readOnly=true)
	public PurchaseOrder getOneOrder(Integer id) {

		return dao.getOneOrder(id);
	}

	@Transactional(readOnly=true)	
	public List<PurchaseOrder> getAllOrders() {
		return dao.getAllOrders();
	}

}
