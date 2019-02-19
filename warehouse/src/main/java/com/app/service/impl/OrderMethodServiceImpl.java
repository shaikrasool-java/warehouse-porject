package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService{

	@Autowired
	private IOrderDao dao;

	@Transactional
	public Integer saveOrder(OrderMethod order) {
		return dao.saveOrder(order);
	}

	@Transactional
	public void updateOrder(OrderMethod order) {
		dao.updateOrder(order);
	}

	@Transactional
	public void deleteOrder(Integer id) {
		dao.deleteOrder(id);	
	}

	@Transactional(readOnly=true)
	public OrderMethod getOneOrder(Integer id) {
		return dao.getOneOrder(id);
	}

	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrders() {
		return dao.getAllOrders();
	}
	@Override
	public List<OrderMethod> getOrderMethodsByMode(String mode) {
		return dao.getOrderMethodsByMode(mode);
	}
	@Override
	public boolean isOrderMethodCodeExist(String code) {
		return dao.isOrderMethodCodeExist(code);
	}
}
